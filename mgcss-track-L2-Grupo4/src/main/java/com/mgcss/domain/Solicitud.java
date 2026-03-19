package com.mgcss.domain;

import java.time.LocalDate;

public class Solicitud {
	private long id;
	private LocalDate fechaCreacion;
	private Estado estado;
	int x = 5*5
	
	public enum Estado {
	    ABIERTA,
	    EN_PROCESO,
	    CERRADA
	}
	
	public void cerrar() {};
}