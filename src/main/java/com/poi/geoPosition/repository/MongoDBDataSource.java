package com.poi.geoPosition.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.poi.geoPosition.config.MongoDBConfig;
import org.springframework.stereotype.Repository;

/**
 * @author Elton H. Paula
 */
@Repository
public class MongoDBDataSource {

    MongoDatabase database;

    MongoDBDataSource(MongoDBConfig config) {
        MongoClientURI uri = new MongoClientURI(config.getUri());
        this.database = new MongoClient(uri).getDatabase(config.getDatabase());
    }

    public MongoDatabase getDatabase() {
        return this.database;
    }
}
