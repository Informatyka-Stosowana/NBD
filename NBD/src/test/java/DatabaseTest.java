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
        ClientRepository cr = new ClientRepository(emf);

        // Test if client in db
        cr.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);
        Assertions.assertEquals(em.find(Client.class, 1).getPersonalId(), 1);

        // Test same id
        cr.addClient(1, "Jacek", "Stos", "Uliczna", 12, "Sosnowiec", 12121);
        Assertions.assertNotEquals(cr.getClient(1).getFirstName(), "Jacek");
    }

    @Test
    public void removeTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientRepository cr = new ClientRepository(emf);

        cr.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);

        // Test if client in db
        Assertions.assertNotNull(em.find(Client.class, 1));

        // Test if client not in db
        cr.removeClient(cr.getClient(1));
        em.clear();
        Assertions.assertNull(em.find(Client.class, 1));
    }

    @Test
    public void maxRentTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientRepository cr = new ClientRepository(emf);
        VehicleRepository vr = new VehicleRepository(emf);
        RentRepository rr = new RentRepository(emf, cr, vr);

        cr.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);
        vr.addCar(1, 2000, "red", 1000, 5);
        vr.addCar(2, 2000, "red", 1000, 5);
        vr.addCar(3, 2000, "red", 1000, 5);

        rr.addRent(1, 1, 1);
        rr.addRent(1, 2, 2);

        Assertions.assertFalse(rr.addRent(1, 3, 3));
        Assertions.assertNull(em.find(Rent.class, 3));
    }

    @Test
    public void removeRentTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        ClientRepository cr = new ClientRepository(emf);
        VehicleRepository vr = new VehicleRepository(emf);
        RentRepository rr = new RentRepository(emf, cr, vr);

        cr.addClient(1, "Paweł", "Stos", "Uliczna", 12, "Sosnowiec", 12121);
        vr.addCar(1, 2000, "red", 1000, 5);

        rr.addRent(1, 1, 1);

        Assertions.assertNotNull(rr.getRent(1));

        rr.endRent(rr.getRent(1));

        Assertions.assertFalse(rr.getRent(1).getVehicle().isRented());
        Assertions.assertEquals(0, rr.getRent(1).getClient().getCurrentRents().size());
    }
}