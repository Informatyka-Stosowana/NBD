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
        clientRepository.getMongoDatabase().drop();
        clientRepository.addClient(clientAddress);
        Assertions.assertNotNull(clientRepository.getClient(1));

        clientRepository.removeClient(1);

        Assertions.assertNull(clientRepository.getClient(1));
    }

    @Test
    public void modifyClientTest() {

        ClientAddress clientAddress = new ClientAddress(1, "Pablo", "Escobar", "Uliczna", 1, "Mehiko", 121212);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.getMongoDatabase().drop();
        clientRepository.addClient(clientAddress);
        Assertions.assertEquals(clientRepository.getClient(1).getFirstName(), "Pablo");

        clientRepository.updateClient(1, "firstName", "olbaP");

        Assertions.assertEquals(clientRepository.getClient(1).getFirstName(), "olbaP");
    }

    @Test
    public void addRemoveVehicleTest() {
        Vehicle vehicle = new Car("1", 100, "Pink", 0.0000001, 0, 15);

        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.getMongoDatabase().drop();
        vehicleRepository.addVehicle(vehicle);
        Assertions.assertNotNull(vehicleRepository.getVehicle("1", "car"));

        vehicleRepository.removeVehicle("1");

        Assertions.assertNull(vehicleRepository.getVehicle("1", "car"));
    }

    @Test
    public void modifyVehicleTest() {
        Vehicle car = new Car("1", 100, "black", 10000.50, 0, 5);

        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.getMongoDatabase().drop();
        vehicleRepository.addVehicle(car);
        Assertions.assertEquals(vehicleRepository.getVehicle("1", "car").getColor(), "black");

        vehicleRepository.updateVehicle("1", "color", "red");

        Assertions.assertEquals(vehicleRepository.getVehicle("1", "car").getColor(), "red");
    }
}
