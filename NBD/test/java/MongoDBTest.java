import com.mongodb.MongoWriteException;
import model.Car;
import model.ClientAddress;
import model.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import storage.ClientRepository;
import storage.VehicleRepository;

public class MongoDBTest {

    @Test
    public void addRemoveClientTest() {
        ClientAddress clientAddress = new ClientAddress(1, "Pablo", "Escobar", "Uliczna", 1, "Mehiko", 121212);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.addClient(clientAddress);
        Assertions.assertNotNull(clientRepository.getClient(1));

        clientRepository.removeClient(1);

        Assertions.assertNull(clientRepository.getClient(1));

        clientRepository.getMongoDatabase().drop();
    }

    @Test
    public void modifyClientTest() {

        ClientAddress clientAddress = new ClientAddress(1, "Pablo", "Escobar", "Uliczna", 1, "Mehiko", 121212);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.addClient(clientAddress);
        Assertions.assertEquals(clientRepository.getClient(1).getFirstName(), "Pablo");

        clientRepository.updateClient(1, "firstName", "olbaP");

        Assertions.assertEquals(clientRepository.getClient(1).getFirstName(), "olbaP");

        clientRepository.getMongoDatabase().drop();
    }

    @Test
    public void addRemoveVehicleTest() {
        Vehicle vehicle = new Car("1", 100, "Pink", 0.0000001, 0, 15);

        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.addVehicle(vehicle);
        Assertions.assertNotNull(vehicleRepository.getVehicle("1", "car"));

        vehicleRepository.removeVehicle("1");

        Assertions.assertNull(vehicleRepository.getVehicle("1", "car"));

        vehicleRepository.getMongoDatabase().drop();
    }

    @Test
    public void modifyVehicleTest() {
        Vehicle car = new Car("1", 100, "black", 10000.50, 0, 5);

        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.addVehicle(car);
        Assertions.assertEquals(vehicleRepository.getVehicle("1", "car").getColor(), "black");

        vehicleRepository.updateVehicle("1", "color", "red");

        Assertions.assertEquals(vehicleRepository.getVehicle("1", "car").getColor(), "red");
        vehicleRepository.getMongoDatabase().drop();
    }

    @Test
    public void vehicleSchemaTest() {
        Vehicle car1 = new Car("1", 100, "black", 10000.50, 0, 5);
        Vehicle car2 = new Car("2", 100, "black", 10000.50, 1, 5);
        Vehicle car3 = new Car("3", 100, "black", 10000.50, 2, 5);
        VehicleRepository vehicleRepository = new VehicleRepository();

        Assertions.assertDoesNotThrow(() -> {
            vehicleRepository.addVehicle(car1);
            vehicleRepository.addVehicle(car2);
        });

        Assertions.assertThrows(MongoWriteException.class, () -> {
            vehicleRepository.addVehicle(car3);
        });

        vehicleRepository.getMongoDatabase().drop();
    }
}
