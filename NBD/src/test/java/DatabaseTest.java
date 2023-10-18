import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    @Test
    public void addTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientManager cm = new ClientManager(new Repository<>(), emf);

        cm.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);

        Client foundClient = em.find(Client.class, cm.getClient(1).getPersonalId());
        Assertions.assertEquals(foundClient.getPersonalId(), cm.getClient(1).getPersonalId());
    }

    @Test
    public void removeTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientManager cm = new ClientManager(new Repository<>(), emf);

        cm.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);

        Client foundClient = em.find(Client.class, cm.getClient(1).getPersonalId());
        Assertions.assertEquals(foundClient.getPersonalId(), cm.getClient(1).getPersonalId());

        cm.removeClient(cm.getClient(1));

        em.clear();
        Assertions.assertNull(em.find(Client.class, 1));
    }

    @Test
    public void repositoryTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        Repository<Client> clientRepository = new Repository<>();
        ClientManager cm = new ClientManager(clientRepository, emf);

        cm.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);

        Assertions.assertEquals(clientRepository.get(0).getPersonalId(), 1);

        cm.removeClient(cm.getClient(1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { clientRepository.get(0); });
    }

    @Test
    public void maxRentTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientManager cm = new ClientManager(new Repository<>(), emf);
        VehicleManager vm = new VehicleManager(new Repository<>(), emf);
        RentManager rm = new RentManager(new Repository<>(), emf);

        cm.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);
        vm.addCar(1, 2000, "red", 1000, 5);
        vm.addCar(2, 2000, "red", 1000, 5);
        vm.addCar(3, 2000, "red", 1000, 5);

        rm.addRent(cm.getClient(1), vm.getVehicle(1), 1);
        rm.addRent(cm.getClient(1), vm.getVehicle(2), 2);

        Assertions.assertFalse(rm.addRent(cm.getClient(1), vm.getVehicle(3), 3));
        Assertions.assertNull(em.find(Rent.class, 3));
    }
}