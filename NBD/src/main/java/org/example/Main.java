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
//        Student student = new Student();
//        student.setName("Kowalski");
//        em.getTransaction().begin();
//        em.persist(student);
//        em.getTransaction().commit();

        RentManager rm = new RentManager();

        Address address1 = new Address("Uliczna", 12, "Sosnowiec", 12121);
        Client client1 = new Client(1, address1, "Rafał", "Woźniak");
        Vehicle car1 = new Car(1, 500, "red", 200.5, 5);
        Vehicle car2 = new Car(1, 400, "blue", 200.5, 5);
        Vehicle car3 = new Car(1, 300, "black", 200.5, 5);
        Rent rent1 = new Rent(1, client1, car1);

        System.out.println(rm.addRent(client1, car1, 1));
        System.out.println(rm.addRent(client1, car2, 2));
        System.out.println(rm.addRent(client1, car3, 3));

        System.out.println(rent1.getClient().getFirstName() + " " + rent1.getVehicle().getWeight() + "Pro");
    }
}