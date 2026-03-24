package com.mgcss.domain;

import java.time.LocalDate;

public class Solicitud {
	private long id;
	private LocalDate fechaCreacion;
	private Estado estado;
	
	public enum Estado {
	    ABIERTA,
	    EN_PROCESO,
	    CERRADA
	}
	
	
    public Solicitud() {
        this.estado = Estado.ABIERTA;
    }

    public Estado getEstado() {
        return estado;
    }
    public void iniciarProceso() {
        this.estado = Estado.EN_PROCESO;
        
    }


	public void cerrar() {
		 if (estado != Estado.EN_PROCESO) {
		        throw new IllegalStateException("No se puede cerrar si no está en proceso");
		    }
		    estado = Estado.CERRADA;
	};
}
