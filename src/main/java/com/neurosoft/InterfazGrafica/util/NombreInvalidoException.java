package com.neurosoft.InterfazGrafica.util;

public class NombreInvalidoException extends NegocioException {
    public NombreInvalidoException() {
    }

    public NombreInvalidoException(String message) {
        super(message);
    }

    public NombreInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NombreInvalidoException(Throwable cause) {
        super(cause);
    }

    public NombreInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
