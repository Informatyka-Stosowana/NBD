package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class ClientManager {
    private Repository<Client> clients;
    private EntityManagerFactory emf;

    public ClientManager(Repository<Client> clients, EntityManagerFactory emf) {
        this.clients = clients;
        this.emf = emf;
    }


    public Client getClient(int id) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getPersonalId() == id) {
                return client;
            }
        }
        return null;
    }

    public boolean addClient(int personalId, String firstName, String lastName, String street, int streetNumber, String city, int postcode) {
        // Spełnienie wymagań biznesowych
        Address address = new Address(street,streetNumber, city, postcode);
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getPersonalId() == personalId) {
                return false;
            }
        }
        Client newClient = new Client(personalId, address, firstName, lastName);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        clients.add(newClient);
//
//        em.persist(newClient);
//        em.getTransaction().commit();
//
//        emf.close();
//
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            clients.add(newClient);
            em.persist(newClient);

            transaction.commit();
        } catch (Exception e) {
            clients.remove(newClient);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
}
