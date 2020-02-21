package com.poi.geoPosition.router;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Elton H. Paula
 */
@Component
public class CollectRouter {

    private final PoiVehicleHandler poiVehicleHandler;


    public CollectRouter(PoiVehicleHandler poiVehicleHandler) {
        this.poiVehicleHandler = poiVehicleHandler;
    }

    @Bean
    public RouterFunction collectFunction() {
        return route(GET("poiVehicles").and(accept(APPLICATION_JSON)), poiVehicleHandler::processPoiVehicleList);
    }
}
