package model;

import java.util.*;

public class RentManager {

    private int MAX_RENTS = 2;
    private ArrayList<Rent> archiveRents = new ArrayList<>();
    public RentManager() {
    }

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
        // em.getTransaction().commit();
        return true;
    }

    public void removeRent(Client client, int id) {
        ArrayList<Rent> currentRents = client.getCurrentRents();
        for (Rent currentRent : currentRents) {
            if (currentRent.getId() == id) {
                currentRent.getVehicle().setRented(false);
                client.deleteRent(currentRent);
                archiveRents.add(currentRent);
                return;
            }
        }
    }
}