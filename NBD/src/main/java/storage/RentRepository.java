package storage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Rent;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class RentRepository extends AbstractMongoRepository {

    public RentRepository() {
        initDbConnection();
        if (!getMongoDatabase().listCollectionNames().into(new ArrayList()).contains("rents")) {
            initCollection();
        }
    }

    public void initCollection() {
//        ValidationOptions validationOptions = new ValidationOptions().validator(
//                Document.parse("""
//                        {
//                            $jsonSchema:{
//                                "bsonType": "object",
//                                "properties": {
//                                    "rented": {
//                                        "bsonType": "int",
//                                        "minimum" : 0,
//                                        "maximum" : 1
//                                        "description": "must be 1 for rented and 0 for available"
//                                    }
//                                }
//                            }
//                        }
//                        """));
//        CreateCollectionOptions createCollectionOptions =
//                new CreateCollectionOptions().validationOptions(validationOptions);
//        getMongoDatabase().createCollection("rents", createCollectionOptions);
        getMongoDatabase().createCollection("rents");
    }

    public Rent getRent(String id) {
        MongoCollection<Rent> rentCollection = getMongoDatabase().getCollection("rents", Rent.class);
        Bson filter = Filters.and(
                Filters.eq("_id", id)
        );
        ArrayList<Rent> rentArrayList = rentCollection.find(filter).into(new ArrayList<>());
        if (rentArrayList.isEmpty()) return null;
        return rentArrayList.get(0);
    }

    public void addRent(Rent rent) {
        // TODO implement toMongoDb in rent
//        MongoCollection<Rent> rentCollection = getMongoDatabase().getCollection("rents", Rent.class);
//        rentCollection.insertOne(vehicle);
    }

    public boolean updateRent(String id, String fieldToUpdate, String value) {
        MongoCollection<Rent> rentCollection = getMongoDatabase().getCollection("rents", Rent.class);
        if (rentCollection.countDocuments() == 0) return false;

        Bson filter = Filters.eq("_id", id);
        Bson setUpdate = Updates.set(fieldToUpdate, value);
        rentCollection.updateOne(filter, setUpdate);

        return true;
    }

    public void removeRent(String id) {
        MongoCollection<Rent> rentCollection = getMongoDatabase().getCollection("rents", Rent.class);

        Bson filter = Filters.eq("_id", id);
        rentCollection.findOneAndDelete(filter);
    }

    @Override
    public void close() throws Exception {

    }
}