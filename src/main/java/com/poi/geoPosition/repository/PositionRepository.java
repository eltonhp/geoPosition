package com.poi.geoPosition.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import com.poi.geoPosition.exception.PoiException;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


/**
 * @author Elton H. Paula
 */
@Repository
public class PositionRepository {

    MongoCollection<Document> collection;

    PositionRepository(MongoDBDataSource mongoDBDataSource) {
        System.out.println(mongoDBDataSource);
        this.collection = mongoDBDataSource.getDatabase().getCollection("positions");
        collection.createIndex(Indexes.geo2dsphere("location"));
    }

    public Iterable getPositionsByPoi(Document poi) {
         if(poi == null) {
             throw new PoiException("O poi não pode ser nulo");
         }

         if(poi.get("location") == null) {
             throw new PoiException(PoiException.NOT_FOUND_COORDINATES);
         }

         Document document = (Document) poi.get("location");

         if(document.get("coordinates") == null || !(document.get("coordinates") instanceof  ArrayList)) {
             throw new PoiException(PoiException.NOT_FOUND_COORDINATES);
         }

         ArrayList<Double> coordinates =  (ArrayList<Double>)  document.get("coordinates");

         if(coordinates.size() < 2) {
             throw new RuntimeException("As coordenadas não contém a latitude e longitude");
         }

         if(poi.get("raio") == null || !(poi.get("raio") instanceof  Integer)) {
             throw new PoiException("O raio do ponto de referência não foi encontrado");
         }

         Double r =  new Double((Integer)poi.get("raio"));
         Double lat =  coordinates.get(1);
         Double log =  coordinates.get(0);
         Point refPoint = new Point(new Position(lat, log));
         return  this.collection.find(Filters.geoWithinCenter("location", log, lat, r));

    }


}
