package storage;

import redis.ClientAddress;

public class ClientRedisRepository extends AbstractRedisRepository {


    public ClientRedisRepository() {
        initDbConnection();
    }

    public ClientAddress getClient(int personalId) {
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
