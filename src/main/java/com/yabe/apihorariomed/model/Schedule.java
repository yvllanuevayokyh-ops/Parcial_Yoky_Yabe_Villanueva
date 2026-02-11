package com.yabe.apihorariomed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Schedule - Representa un horario de medicamento
 * 
 * @author YABE
 * @version 1.0
 */
@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    /**
     * ID único del horario (Primary Key)
     * Generado automáticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Nombre del medicamento
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Dosis del medicamento (ej: "500mg", "1 tableta")
     */
    @Column(name = "dosis", nullable = false, length = 50)
    private String dosis;

    /**
     * Hora de administración (formato HH:mm)
     */
    @Column(name = "hora", nullable = false, length = 5)
    private String hora;

    /**
     * Frecuencia de administración (ej: "Cada 8 horas", "Diario")
     */
    @Column(name = "frecuencia", nullable = false, length = 50)
    private String frecuencia;

    /**
     * Notas adicionales (opcional)
     */
    @Column(name = "notas", length = 500)
    private String notas;

    /**
     * Estado del horario (activo/inactivo)
     */
    @Column(name = "activo", nullable = false)
    private boolean activo;

    /**
     * Constructor sin ID (para creación de nuevos registros)
     */
    public Schedule(String nombre, String dosis, String hora, String frecuencia, String notas, boolean activo) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.hora = hora;
        this.frecuencia = frecuencia;
        this.notas = notas;
        this.activo = activo;
    }
}
