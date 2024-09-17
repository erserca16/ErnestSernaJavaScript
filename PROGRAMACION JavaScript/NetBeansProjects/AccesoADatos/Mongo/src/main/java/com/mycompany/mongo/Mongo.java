package com.mycompany.mongo;

import com.mongodb.MongoClient;
import java.util.List;

public class Mongo {

    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        
        if (mongo != null)   {
            List dbs = mongo.getDatabaseNames();
            for (int i = 0; i < dbs.size(); i++) {
                System.out.println(i + " - " + dbs.get(i));
            }
        }
        else {
            System.out.println("Error en la conexión");
                }
    }
}