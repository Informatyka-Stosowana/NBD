package model;

import jakarta.persistence.*;

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
            em.find(Vehicle.class, vehicle.getId(), LockModeType.PESSIMISTIC_WRITE);
            em.find(Client.class, client.getPersonalId(), LockModeType.PESSIMISTIC_WRITE);

            vehicle.setRented(true);
            client.addRent(newRent);
            rents.add(newRent);

            em.persist(newRent);
            em.merge(vehicle);

            transaction.commit();
        } catch (Exception e) {
            vehicle.setRented(false);
            client.removeRent(newRent);
            rents.remove(newRent);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    public Rent getRent(int id) {
        for (int i = 0; i < rents.size(); i++) {
            if (rents.get(i).getId() == id) return rents.get(i);
        }
        return null;
    }

    public void endRent(Rent rent) {
        rent.getVehicle().setRented(false);
        rent.getClient().removeRent(rent);
        rent.setArchive(true);

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            rent.getVehicle().setRented(false);
            rent.getClient().removeRent(rent);
            rent.setArchive(true);

            em.merge(rent.getVehicle());
            em.merge(rent);

            transaction.commit();
        } catch (Exception e) {
            rent.getVehicle().setRented(true);
            rent.getClient().addRent(rent);
            rent.setArchive(false);
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}