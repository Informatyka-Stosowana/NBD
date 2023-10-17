package model;

import jakarta.persistence.*;

import java.util.ArrayList;
public class VehicleManager {
    private Repository<Vehicle> vehicles;
    private EntityManagerFactory emf;

    public VehicleManager(Repository<Vehicle> vehicles, EntityManagerFactory emf) {
        this.vehicles = vehicles;
        this.emf = emf;
    }

    private boolean addVehicle(Vehicle vehicle) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            vehicles.add(vehicle);
            em.persist(vehicle);
            transaction.commit();
        } catch (Exception e) {
            vehicles.remove(vehicle);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public boolean addCar(int id, int weight, String color, double price, int numberOfSeats) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getId() == id) return false;
        }
        return addVehicle(new Car(id, weight, color, price, numberOfSeats));
    }

    public boolean addBicycle(int id, int weight, String color, double price, boolean helperWheels) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return false;
        }
        return addVehicle(new Bicycle(id, weight, color, price, helperWheels));
    }

    public boolean addMotorcycle(int id, int weight, String color, double price, int engineDisplacement) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return false;
        }
        return addVehicle(new Motorcycle(id, weight, color, price, engineDisplacement));
    }

    public void removeVehicle(Vehicle vehicle) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            vehicles.remove(vehicle);
            em.remove(em.find(Vehicle.class, vehicle.getId()));

            transaction.commit();
        } catch (Exception e) {
            vehicles.add(vehicle);
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public Vehicle getVehicle(int id) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) return vehicles.get(i);
        }
        return null;
    }
}
