package com.poi.geoPosition.service;

import com.poi.geoPosition.repository.PositionRepository;
import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.springframework.stereotype.Service;

/**
 * @author Elton
 */
@Service
public class PositionService {

    private PositionRepository positionRepository;

    PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public Iterable<?> getPositionsByPoi(Document poi) {



        return positionRepository.getPositionsByPoi(poi);
    }
}
