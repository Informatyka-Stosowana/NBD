package storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class AbstractMongoRepository implements AutoCloseable {
    private final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    private final MongoCredential mongoCredential = MongoCredential.createCredential("admin", "admin",
            "adminpassword".toCharArray());

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private void initDbConnection() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(mongoCredential)
                .applyConnectionString(connectionString)
                .build();

        mongoClient = (MongoClient) MongoClients.create(settings);
        mongoDatabase = mongoClient.getDatabase("rentDB");
    }
}
