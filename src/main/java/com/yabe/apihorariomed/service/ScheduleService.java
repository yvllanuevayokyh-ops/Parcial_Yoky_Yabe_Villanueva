package com.yabe.apihorariomed.service;

import com.yabe.apihorariomed.model.Schedule;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de horarios de medicamentos
 * 
 * @author YABE
 * @version 1.0
 */
public interface ScheduleService {

    /**
     * Obtener todos los horarios
     * @return Lista de todos los horarios
     */
    List<Schedule> getAllSchedules();

    /**
     * Obtener un horario por ID
     * @param id ID del horario
     * @return Horario encontrado
     */
    Optional<Schedule> getScheduleById(Integer id);

    /**
     * Crear un nuevo horario
     * @param schedule Datos del horario
     * @return Horario creado
     */
    Schedule createSchedule(Schedule schedule);

    /**
     * Actualizar un horario existente
     * @param id ID del horario
     * @param scheduleDetails Nuevos datos del horario
     * @return Horario actualizado
     */
    Schedule updateSchedule(Integer id, Schedule scheduleDetails);

    /**
     * Eliminar un horario
     * @param id ID del horario
     */
    void deleteSchedule(Integer id);

    /**
     * Obtener horarios activos
     * @return Lista de horarios activos
     */
    List<Schedule> getActiveSchedules();

    /**
     * Obtener horarios inactivos
     * @return Lista de horarios inactivos
     */
    List<Schedule> getInactiveSchedules();

    /**
     * Buscar horarios por nombre
     * @param nombre Nombre del medicamento
     * @return Lista de horarios que coinciden
     */
    List<Schedule> searchByNombre(String nombre);

    /**
     * Obtener horarios por hora
     * @param hora Hora en formato HH:mm
     * @return Lista de horarios para esa hora
     */
    List<Schedule> getSchedulesByHora(String hora);

    /**
     * Contar horarios activos
     * @return Número de horarios activos
     */
    long countActiveSchedules();
}
