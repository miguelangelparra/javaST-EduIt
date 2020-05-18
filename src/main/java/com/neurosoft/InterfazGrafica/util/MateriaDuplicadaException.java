package com.neurosoft.InterfazGrafica.util;

public class MateriaDuplicadaException extends NegocioException {
    public MateriaDuplicadaException() {
    }

    public MateriaDuplicadaException(String message) {
        super(message);
    }

    public MateriaDuplicadaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MateriaDuplicadaException(Throwable cause) {
        super(cause);
    }

    public MateriaDuplicadaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
