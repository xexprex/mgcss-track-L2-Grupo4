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
	
	public void cerrar() {};
}
