package model;

import com.mongodb.MongoClient;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        //Creating a MongoDB client
        @SuppressWarnings("resource")
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Accessing the database
        mongo.getDatabase("admin");
        System.out.println("Databases created successfully");
    }
}
