import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.ClientManager;
import model.Repository;
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
}