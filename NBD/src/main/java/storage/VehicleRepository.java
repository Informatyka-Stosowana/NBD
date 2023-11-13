package storage;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Vehicle;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class VehicleRepository extends AbstractMongoRepository {

    public VehicleRepository() {
        initDbConnection();
    }

    public Vehicle getVehicle(String id, String vehicleType) {
        MongoCollection<Vehicle> vehicleCollection = getMongoDatabase().getCollection("vehicles", Vehicle.class);
        Bson filter = Filters.and(
                Filters.eq("_clazz", vehicleType),
                Filters.eq("_id", id)
        );
        ArrayList<Vehicle> vehicleArrayList = vehicleCollection.find(filter).into(new ArrayList<>());
        if (vehicleArrayList.isEmpty()) return null;
        return vehicleArrayList.get(0);
    }

    public void addVehicle(Vehicle vehicle) {
        MongoCollection<Vehicle> vehicleCollection =
                getMongoDatabase().getCollection("vehicles", Vehicle.class);
        vehicleCollection.insertOne(vehicle);
    }

    public boolean updateVehicle(String id, String fieldToUpdate, String value) {
        MongoCollection<Vehicle> vehicleCollection = getMongoDatabase().getCollection("vehicles", Vehicle.class);
        if (vehicleCollection.countDocuments() == 0) return false;

        Bson filter = Filters.eq("_id", id);
        Bson setUpdate = Updates.set(fieldToUpdate, value);
        vehicleCollection.updateOne(filter, setUpdate);

        return true;
    }

    public void removeVehicle(String id) {
        MongoCollection<Vehicle> vehicleCollection = getMongoDatabase().getCollection("vehicles", Vehicle.class);

        Bson filter = Filters.eq("_id", id);
        vehicleCollection.findOneAndDelete(filter);
    }

    @Override
    public void close() throws Exception {

    }
}