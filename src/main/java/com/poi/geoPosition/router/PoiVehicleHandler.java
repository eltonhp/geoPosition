package com.poi.geoPosition.router;

import com.poi.geoPosition.model.PoiVehicle;
import com.poi.geoPosition.service.PoiService;
import com.poi.geoPosition.service.PositionService;
import javafx.geometry.Pos;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.Doc;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class PoiVehicleHandler {
    PoiService poiService;
    PositionService positionService;

    PoiVehicleHandler(PoiService poiService, PositionService positionService) {
        this.poiService = poiService;
        this.positionService = positionService;
    }

    public Mono<ServerResponse> processPoiVehicleList(ServerRequest req) {

        //Obter a lista de pois


        //Obter a lista de positions por pois (cordenadas)
        // Devolver a lista de poiVehicle (veiculo, tempo, poiName)

        Flux<Document> flux = Flux.fromIterable(poiService.getPoiList());

        Flux<Object> r =  flux.flatMapIterable(poi -> this.positionService.getPositionsByPoi(poi));
        return ok().contentType(MediaType.APPLICATION_JSON).body(r, Object.class)
                .onErrorMap( e -> new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage()));




    }
}
