package com.mgcss.controller;

import com.mgcss.service.SolicitudService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
	private final SolicitudService solicitudService;

    // Inyección por constructor del servicio (Delegación)
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    /**
     * Endpoint para asignar un técnico a una solicitud.
     * No contiene lógica de negocio, solo llama al servicio.
     */
    @PostMapping("/{id}/tecnico")
    public ResponseEntity<Void> asignarTecnico(
            @PathVariable Long id, 
            @RequestBody SolicitudRequestDTO request) {
        
        // Delegamos la operación al servicio
        solicitudService.asignarTecnico(id, request.tecnicoId());
        
        return ResponseEntity.ok().build();
    }
    
    /**
     * POST -> crear
     * Crea una nueva solicitud. Devuelve 201 Created.
     */
    @PostMapping
    public ResponseEntity<SolicitudResponseDTO> crear() {
        SolicitudResponseDTO nueva = solicitudService.crearSolicitud();
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    /**
     * GET -> consultar
     * Recupera el detalle de una solicitud por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> consultar(@PathVariable Long id) {
        SolicitudResponseDTO solicitud = solicitudService.obtenerSolicitud(id);
        return ResponseEntity.ok(solicitud);
    }

    /**
     * PUT -> actualizar estado
     * Transiciona el estado (ej. de ABIERTA a EN_PROCESO o CERRADA).
     */
    @PutMapping("/{id}/cerrar")
    public ResponseEntity<Void> cerrar(@PathVariable Long id) {
        solicitudService.cerrarSolicitud(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * PATCH -> reabrir
     * Acción parcial para volver a poner en proceso una solicitud cerrada.
     */
    @PatchMapping("/{id}/reabrir")
    public ResponseEntity<Void> reabrir(@PathVariable Long id) {
        solicitudService.reabrirSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}
