package model;

import jakarta.persistence.*;

public class VehicleRepository {
    private EntityManagerFactory emf;

    public VehicleRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private boolean addVehicle(Vehicle vehicle) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(vehicle);

            transaction.commit();
        } catch (Exception e) {
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
        return addVehicle(new Car(id, weight, color, price, numberOfSeats));
    }

    public boolean addBicycle(int id, int weight, String color, double price, boolean helperWheels) {
        return addVehicle(new Bicycle(id, weight, color, price, helperWheels));
    }

    public boolean addMotorcycle(int id, int weight, String color, double price, int engineDisplacement) {
        return addVehicle(new Motorcycle(id, weight, color, price, engineDisplacement));
    }

    public void removeVehicle(int vehicleId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.remove(em.find(Vehicle.class, vehicleId));

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public Vehicle getVehicle(int vehicleId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Vehicle.class, vehicleId);
    }
}
