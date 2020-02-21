package com.poi.geoPosition.service;

import com.mongodb.client.MongoCollection;
import com.poi.geoPosition.model.PoiVehicle;
import com.poi.geoPosition.repository.PoiRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elton H. Paula
 */
@Service
public class PoiService {

    PoiRepository poiRepository;

    PoiService(PoiRepository poiRepository) {
        this.poiRepository =  poiRepository;
    }

    public List<PoiVehicle> getPoiVehicleList() {


        List<PoiVehicle> list = new ArrayList();

        PoiVehicle pv = new PoiVehicle();
        PoiVehicle pv2 = new PoiVehicle();
        pv.setName("p1");
        pv2.setName("p2");

        list.add(pv);
        list.add(pv2);

        return list;

    }

    public Iterable getPoiList() {
        return this.poiRepository.getPoiList();
    }
}
