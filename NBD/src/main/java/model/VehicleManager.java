package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
public class VehicleManager {
    private Repository<Vehicle> vehicles = new Repository<>();

    public boolean addCar(int id, int weight, String color, double price, int numberOfSeats) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getId() == id) return false;
        }
        Car newCar = new Car(id, weight, color, price, numberOfSeats);

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        vehicles.add(newCar);
        // em.persist(newCar);
        // em.getTransaction().commit();
        return true;
    }

    public boolean addBicycle(int id, int weight, String color, double price, boolean helperWheels) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return false;
        }
        Bicycle newBicycle = new Bicycle(id, weight, color, price, helperWheels);

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        vehicles.add(newBicycle);
        // em.persist(newBicycle);
        // em.getTransaction().commit();
        return true;
    }

    public boolean addMotorcycle(int id, int weight, String color, double price, int engineDisplacement) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return false;
        }
        Motorcycle newMotorcycle = new Motorcycle(id, weight, color, price, engineDisplacement);

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        vehicles.add(newMotorcycle);
        // em.persist(newMotorcycle);
        // em.getTransaction().commit();
        return true;
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public Vehicle getVehicle(int id) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return vehicles.get(i);
        }
        return null;
    }
}
