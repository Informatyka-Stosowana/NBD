package storage;

import jakarta.persistence.*;
import model.Client;
import model.Rent;
import model.Vehicle;

public class RentRepository {

    private int MAX_RENTS = 2;
    private EntityManagerFactory emf;
    private ClientRepository cr;
    private VehicleRepository vr;

    public RentRepository(EntityManagerFactory emf, ClientRepository cr, VehicleRepository vr) {
        this.emf = emf;
        this.cr = cr;
        this.vr = vr;
    }

    public boolean addRent(int clientId, int vehicleId, int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Vehicle vehicle = em.find(Vehicle.class, vehicleId, LockModeType.PESSIMISTIC_WRITE);
            Client client = em.find(Client.class, clientId, LockModeType.PESSIMISTIC_WRITE);

            // Spełnienie wymagań biznesowych
            if (client == null) throw new Exception("Client does not exist");
            if (vehicle == null) throw new Exception("Vehicle does not exist");
            if (vehicle.isRented()) throw new Exception("Vehicle is rented");
            if (client.getCurrentRents().size() >= MAX_RENTS) throw new Exception("Client max rents");

            Rent newRent = new Rent(id, client, vehicle);
            vehicle.setRented(true);
            client.addRent(newRent);

            em.persist(newRent);
            em.merge(vehicle);

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

    public Rent getRent(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Rent.class, id);
    }

    public void endRent(Rent rent) {
        EntityManager em = emf.createEntityManager();

        Vehicle vehicle = vr.getVehicle(rent.getVehicle().getId());
        Client client = cr.getClient(rent.getClient().getPersonalId());

        vehicle.setRented(false);
        client.removeRent(rent.getId());
        rent.setArchive(true);

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.merge(vehicle);
            em.merge(client);
            em.merge(rent);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}