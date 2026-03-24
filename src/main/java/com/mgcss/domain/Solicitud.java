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
	
	
	public Estado getEstado(Estado est) {
		this.estado=est;
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public void cerrar() {};
}
