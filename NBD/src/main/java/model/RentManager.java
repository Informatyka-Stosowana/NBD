package model;

import jakarta.persistence.*;

import java.util.*;

public class RentManager {

    private int MAX_RENTS = 2;
    private Repository<Rent> rents;
    private EntityManagerFactory emf;

    public RentManager(Repository<Rent> rents, EntityManagerFactory emf) {
        this.rents = rents;
        this.emf = emf;
    }

    public boolean addRent(Client client, Vehicle vehicle, int id) {
        // Spełnienie wymagań biznesowych
        if (client.getCurrentRents().size() >= MAX_RENTS) return false;
        if (vehicle.isRented()) return false;

        Rent newRent = new Rent(id, client, vehicle);

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            vehicle.setRented(true);
            client.addRent(newRent);
            rents.add(newRent);

            em.persist(newRent);

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

    public void removeRent(Rent rent) {
        rent.getVehicle().setRented(false);
        rent.getClient().deleteRent(rent);
        rent.setArchive(true);
        // zmiana w bazie
    }
}