package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//        EntityManager em = emf.createEntityManager();
//        Address address = new Address("Uliczna", 12, "Sosnowiec", 12121);
//        Client client = new Client(1, address, "Rafał", "Woźniak");
//        Client client1 = new Client(2, address, "Rafeł", "Woźniak");
//        em.getTransaction().begin();
//        em.persist(client);
//        em.getTransaction().commit();
//
//        em.close();
//
//        EntityManager em1 = emf.createEntityManager();

//        em1.getTransaction().begin();
//        em1.persist(client1);
//        em1.getTransaction().commit();


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        RentManager rm = new RentManager(new Repository<>(), emf);
        ClientManager cm = new ClientManager(new Repository<>(), emf);
        VehicleManager vm = new VehicleManager(new Repository<>(), emf);

        cm.addClient(1, "Rafał", "Woźniak", "Uliczna", 12, "Sosnowiec", 12121);
        vm.addCar(1, 500, "red", 200.5, 5);
        rm.addRent(cm.getClient(1), vm.getVehicle(1), 1);

//        Address address1 = new Address("Uliczna", 12, "Sosnowiec", 12121);
//        Client client1 = new Client(1, address1, "Rafał", "Woźniak");
//        Vehicle car1 = new Car(1, 500, "red", 200.5, 5);
//        Vehicle car2 = new Car(1, 400, "blue", 200.5, 5);
//        Vehicle car3 = new Car(1, 300, "black", 200.5, 5);
//        Rent rent1 = new Rent(1, client1, car1);
//
//        System.out.println(rm.addRent(client1, car1, 1));
//        System.out.println(rm.addRent(client1, car2, 2));
//        System.out.println(rm.addRent(client1, car3, 3));
//
//        System.out.println(rent1.getClient().getFirstName() + " " + rent1.getVehicle().getWeight() + "Pro");
    }
}