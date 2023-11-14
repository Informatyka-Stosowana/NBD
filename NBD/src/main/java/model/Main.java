package model;

import storage.ClientRepository;

public class Main {
    public static void main(String[] args) {

        ClientAddress clientAddress = new ClientAddress(1, "Paweł", "Stus", "Uliczna", 1, "Łódź", 121212);
        ClientAddress clientAddress2 = new ClientAddress(2, "Paweł", "Stuz", "Uliczna", 1, "Łódź", 121212);

        ClientRepository clientRepository = new ClientRepository();
//        clientRepository.addClient(clientAddress);
//        clientRepository.addClient(clientAddress2);

//        System.out.println(clientRepository.getClient(1).getFirstName());
//
//        System.out.println(clientRepository.getClient(2).getFirstName());

//        clientRepository.removeClient(1);


    }
}