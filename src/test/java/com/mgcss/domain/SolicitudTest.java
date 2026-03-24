package com.mgcss.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudTest {
	@Test
    void noSePuedeCerrarSiNoEstaEnProceso() {
        Solicitud solicitud = new Solicitud();
        solicitud.getEstado(Solicitud.Estado.ABIERTA);

        assertThrows(IllegalStateException.class, () -> {
            solicitud.cerrar();
        });
    }

}
