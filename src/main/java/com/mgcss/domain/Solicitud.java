package com.mgcss.domain;

import java.time.LocalDate;

public class Solicitud {
	private long id;
	private LocalDate fechaCreacion;
	private Estado estado;
	private Tecnico tecnico;
	
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
		        throw new IllegalStateException("La solicitud debe estar en proceso para poder cerrarse");
		    }
		    estado = Estado.CERRADA;
	}
	public void asignarTecnico(Tecnico tecnico) {
	    if (!tecnico.isActivo()) {
	        throw new IllegalStateException("El técnico debe estar activo para ser asignado");
	    }
	    this.tecnico = tecnico;
	}

	public Tecnico getTecnico() {
	    return tecnico;
	}
}
