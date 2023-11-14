package storage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.ClientAddress;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class ClientRepository extends AbstractMongoRepository {

    public ClientRepository() {
        initDbConnection();

        // if collection does not exist, create one with correct schema
//        if (!getMongoDatabase().listCollectionNames().into(new ArrayList()).contains("clients")) {
//            ValidationOptions validationOptions = new ValidationOptions().validator();
//            CreateCollectionOptions createCollectionOptions =
//                    new CreateCollectionOptions().validationOptions(validationOptions);
//            getMongoDatabase().createCollection("clients", createCollectionOptions);
//        }
    }

    public ClientAddress getClient(int personalId) {
        MongoCollection<ClientAddress> clientsCollection = getMongoDatabase().getCollection("clients", ClientAddress.class);
        Bson filter = Filters.eq("_id", personalId);
        ArrayList<ClientAddress> clientAddressArrayList = clientsCollection.find(filter).into(new ArrayList<>());
        if (clientAddressArrayList.isEmpty()) return null;
        return clientAddressArrayList.get(0);
    }

    public void addClient(ClientAddress client) {
        MongoCollection<ClientAddress> clientsCollection =
                getMongoDatabase().getCollection("clients", ClientAddress.class);
        clientsCollection.insertOne(client);
    }

    public boolean updateClient(int personalId, String fieldToUpdate, String value) {
        MongoCollection<ClientAddress> clientsCollection = getMongoDatabase().getCollection("clients", ClientAddress.class);
        if (clientsCollection.countDocuments() == 0) return false;

        Bson filter = Filters.eq("_id", personalId);
        Bson setUpdate = Updates.set(fieldToUpdate, value);
        clientsCollection.updateOne(filter, setUpdate);

        return true;
    }

    public void removeClient(int personalId) {
        MongoCollection<ClientAddress> clientsCollection = getMongoDatabase().getCollection("clients", ClientAddress.class);

        Bson filter = Filters.eq("_id", personalId);
        clientsCollection.findOneAndDelete(filter);
    }

    @Override
    public void close() throws Exception {

    }
}
