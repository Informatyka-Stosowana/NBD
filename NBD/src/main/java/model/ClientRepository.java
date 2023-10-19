package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class ClientRepository {
    private EntityManagerFactory emf;

    public ClientRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Client getClient(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Client.class, id);
    }

    public boolean addClient(int personalId, String firstName, String lastName, String street, int streetNumber, String city, int postcode) {
        EntityManager em = emf.createEntityManager();
        // Spełnienie wymagań biznesowych
        if (em.find(Client.class, personalId) != null) return false;

        Address address = new Address(street,streetNumber, city, postcode);
        Client newClient = new Client(personalId, address, firstName, lastName);

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(newClient);

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

    public void removeClient(Client client) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.remove(em.find(Client.class, client.getPersonalId()));

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
