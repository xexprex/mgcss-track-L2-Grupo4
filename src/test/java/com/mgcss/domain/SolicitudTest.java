package com.mgcss.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudTest {
	
	@Test
    void noSePuedeCerrarSiNoEstaEnProceso() {
		Solicitud solicitud = new Solicitud();

	    assertThrows(IllegalStateException.class, () -> {
	        solicitud.cerrar();
	        
	    });
    }
	@Test
	void asignarTecnicoActivoFunciona() {
	    Tecnico tecnico = new Tecnico(true);
	    Solicitud solicitud = new Solicitud();

	    solicitud.asignarTecnico(tecnico);

	    assertEquals(tecnico, solicitud.getTecnico());
	}

	@Test
	void asignarTecnicoInactivoFalla() {
	    Tecnico tecnico = new Tecnico(false);
	    Solicitud solicitud = new Solicitud();

	    assertThrows(IllegalStateException.class, () -> {
	        solicitud.asignarTecnico(tecnico);
	    });
	}

}
