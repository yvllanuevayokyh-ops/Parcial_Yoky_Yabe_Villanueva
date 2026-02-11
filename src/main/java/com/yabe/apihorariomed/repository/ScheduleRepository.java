package com.yabe.apihorariomed.repository;

import com.yabe.apihorariomed.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Schedule
 * Proporciona operaciones CRUD y consultas personalizadas
 * 
 * @author YABE
 * @version 1.0
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    /**
     * Busca todos los horarios activos
     * @return Lista de horarios activos
     */
    List<Schedule> findByActivoTrue();

    /**
     * Busca todos los horarios inactivos
     * @return Lista de horarios inactivos
     */
    List<Schedule> findByActivoFalse();

    /**
     * Busca horarios por nombre (búsqueda parcial, case-insensitive)
     * @param nombre Nombre del medicamento
     * @return Lista de horarios que coinciden
     */
    List<Schedule> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Busca horarios por hora específica
     * @param hora Hora en formato HH:mm
     * @return Lista de horarios para esa hora
     */
    List<Schedule> findByHora(String hora);

    /**
     * Busca horarios activos por frecuencia
     * @param frecuencia Frecuencia del medicamento
     * @return Lista de horarios activos con esa frecuencia
     */
    @Query("SELECT s FROM Schedule s WHERE s.frecuencia = :frecuencia AND s.activo = true")
    List<Schedule> findActiveSchedulesByFrecuencia(@Param("frecuencia") String frecuencia);

    /**
     * Cuenta cuántos horarios activos hay
     * @return Número de horarios activos
     */
    long countByActivoTrue();
}
