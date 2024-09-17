package com.mycompany.actividad3mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.function.Consumer;
import org.bson.Document;

public class Actividad3Mongo {

    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase database = mongoClient.getDatabase("examen");

        MongoCollection<Document> collection = database.getCollection("empleados");

        System.out.println();
        collection.find(Filters.and(Filters.gte("salario", 1050), Filters.lte("salario", 1450)))
                .forEach((Consumer<Document>) document -> System.out.println("Empleados con sueldo entre 1050 y 1450: \n" + document.toJson()));

        System.out.println("\nEmpleados con sueldo mayor de 1300 después de decrementar el salario en 500:");
        collection.updateMany(Filters.gt("salario", 1300), Updates.inc("salario", -500));
        collection.find(Filters.gt("salario", "salario"))
                .forEach((Consumer<Document>) document -> System.out.println(document.toJson()));

        mongoClient.close();
    }
}
