import model.ClientAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import storage.ClientMongoRepository;
import storage.ClientRedisRepository;

public class RedisTest {

    @Test
    public void addClientTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientMongoRepository clientMongoRepository = new ClientMongoRepository();
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository(clientMongoRepository);
        clientRedisRepository.addClient(clientAddress1);

        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        Assertions.assertNull(clientRedisRepository.getClient(2));
        clientRedisRepository.clearCache();
    }

    @Test
    public void removeClientsTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientMongoRepository clientMongoRepository = new ClientMongoRepository();
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository(clientMongoRepository);
        clientRedisRepository.addClient(clientAddress1);

        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        clientRedisRepository.removeClient(1);
        Assertions.assertNull(clientRedisRepository.getClient(1));

        clientRedisRepository.clearCache();
    }

    @Test
    public void clearCacheTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientMongoRepository clientMongoRepository = new ClientMongoRepository();
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository(clientMongoRepository);
        clientRedisRepository.addClient(clientAddress1);


        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        clientRedisRepository.clearCache();
        Assertions.assertNull(clientRedisRepository.getClient(1));
    }

    @Test
    public void noRedisTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientMongoRepository clientMongoRepository = new ClientMongoRepository();
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository(clientMongoRepository);
        clientRedisRepository.addClient(clientAddress1);
        clientMongoRepository.addClient(clientAddress1);

        try {
            clientRedisRepository.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Assertions.assertNotNull(clientRedisRepository.getClient(1));
    }
}
