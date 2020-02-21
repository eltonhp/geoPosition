package com.poi.geoPosition.exception;

/**
 * @author Elton H. Paula
 */
public class PoiException extends  RuntimeException {
    public static final String NOT_FOUND_COORDINATES = "Não foi encontrada as coordenadas dos pontos de referência";

    public PoiException() {
        super();
    }

    public PoiException(String message) {
        super(message);
    }

    public PoiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoiException(Throwable cause) {
        super(cause);
    }

    protected PoiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
