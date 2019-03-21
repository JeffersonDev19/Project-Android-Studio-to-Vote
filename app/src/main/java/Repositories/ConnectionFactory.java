package Repositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class ConnectionFactory {

    public static MongoClient getInstance(){
        try {
            return new MongoClient(new MongoClientURI("mongo"));
        } catch (UnknownHostException e) {
            System.out.println("Excessão de conexão detectada na execução");
            return null;
        }
    }
}
