package storage;

import model.ClientAddress;

public class ClientRedisRepository extends AbstractRedisRepository {

    private final ClientMongoRepository clientMongoRepository;

    public ClientRedisRepository(ClientMongoRepository clientMongoRepository) {
        this.clientMongoRepository = clientMongoRepository;
        initDbConnection();
    }

    public ClientAddress getClient(int personalId) {
        try {
            checkConnection();
        } catch (Exception e) {
            clientMongoRepository.getClient(personalId);
        }
        String temp = getPool().get("client:" + personalId);
        if (temp == null) return null;
        return getJsonb().fromJson(temp, ClientAddress.class);
    }

    public void addClient(ClientAddress client) {
        String entityStr = getJsonb().toJson(client);
        getPool().set("client:" + client.getPersonalId(), entityStr);
    }

    public void removeClient(int personalId) {
        getPool().del("client:" + personalId);
    }
}
