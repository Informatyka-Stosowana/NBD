package model;

import jakarta.persistence.Entity;

import java.util.*;

public class RentManager {

    private int MAX_RENTS = 2;
    private Repository<Rent> rents = new Repository<>();
    
    public boolean addRent(Client client, Vehicle vehicle, int id) {
        // Spełnienie wymagań biznesowych
        if (client.getCurrentRents().size() >= MAX_RENTS) return false;
        if (vehicle.isRented()) return false;

        Rent newRent = new Rent(id, client, vehicle);

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        vehicle.setRented(true);
        client.addRent(newRent);
        rents.add(newRent);
        // em.persist(newRent);
        // em.getTransaction().commit();
        return true;
    }

    public void removeRent(Rent rent) {
        rent.getVehicle().setRented(false);
        rent.getClient().deleteRent(rent);
        rent.setArchive(true);
        // zmiana w bazie
    }
}