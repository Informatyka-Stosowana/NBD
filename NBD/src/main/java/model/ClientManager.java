package model;

import java.util.ArrayList;

public class ClientManager {
    private Repository<Client> clients = new Repository<>();

    public Client getClient(int id) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getPersonalId() == id) {
                return client;
            }
        }
        return null;
    }

    public boolean addClient(int personalId, Address address, String firstName, String lastName) {
        // Spełnienie wymagań biznesowych
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getPersonalId() == personalId) {
                return false;
            }
        }
        
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        // em.persist(newRent);
        // em.getTransaction().commit();

        clients.add(new Client(personalId, address, firstName, lastName));
        return true;
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
}
