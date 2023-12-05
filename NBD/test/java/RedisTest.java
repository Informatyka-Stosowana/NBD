import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import redis.ClientAddress;
import storage.ClientRedisRepository;

public class RedisTest {

    @Test
    public void addClientTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository();
        clientRedisRepository.addClient(clientAddress1);

        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        Assertions.assertNull(clientRedisRepository.getClient(2));
        clientRedisRepository.clearCache();
    }

    @Test
    public void removeClientsTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository();
        clientRedisRepository.addClient(clientAddress1);

        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        clientRedisRepository.removeClient(1);
        Assertions.assertNull(clientRedisRepository.getClient(1));

        clientRedisRepository.clearCache();
    }

    @Test
    public void clearCacheTest() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository();
        clientRedisRepository.addClient(clientAddress1);

        Assertions.assertNotNull(clientRedisRepository.getClient(1));
        clientRedisRepository.clearCache();
        Assertions.assertNull(clientRedisRepository.getClient(1));

    }
}
