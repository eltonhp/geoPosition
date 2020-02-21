package com.poi.geoPosition.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Repository;

/**
 * @author Elton H. Paula
 */
@Repository
public class PoiRepository {
    MongoCollection<Document> collection;

    PoiRepository(MongoDBDataSource mongoDBDataSource) {
        collection = mongoDBDataSource.getDatabase().getCollection("pois");
    }

    public Iterable getPoiList() {
        return  collection.find();
    }
}
