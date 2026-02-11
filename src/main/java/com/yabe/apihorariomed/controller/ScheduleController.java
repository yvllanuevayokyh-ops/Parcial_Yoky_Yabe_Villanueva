package com.yabe.apihorariomed.controller;

import com.yabe.apihorariomed.model.Schedule;
import com.yabe.apihorariomed.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para la gestión de horarios de medicamentos
 * 
 * ENDPOINTS OBLIGATORIOS (según rúbrica):
 * - GET    /schedules       → 200 OK - Listar todos
 * - GET    /schedules/{id}  → 200 OK / 404 Not Found
 * - POST   /schedules       → 201 Created
 * - PUT    /schedules/{id}  → 200 OK / 404 Not Found
 * - DELETE /schedules/{id}  → 204 No Content / 404 Not Found
 * 
 * @author YABE
 * @version 2.0 - Producción
 */
@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = "*") // CORS habilitado para Android y Render
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * GET /schedules - Listar todos los horarios
     * @return 200 OK con lista de horarios
     */
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules); // 200 OK
    }

    /**
     * GET /schedules/{id} - Obtener un horario por ID
     * @param id ID del horario
     * @return 200 OK con el horario, o 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        return scheduleService.getScheduleById(id)
                .map(schedule -> ResponseEntity.ok(schedule)) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    /**
     * POST /schedules - Crear un nuevo horario
     * @param schedule Datos del horario a crear
     * @return 201 Created con el horario creado
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 Created
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleService.createSchedule(schedule);
        return ResponseEntity
                .status(HttpStatus.CREATED) // 201 Created
                .body(createdSchedule);
    }

    /**
     * PUT /schedules/{id} - Actualizar un horario existente
     * @param id ID del horario a actualizar
     * @param scheduleDetails Nuevos datos del horario
     * @return 200 OK con el horario actualizado, o 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(
            @PathVariable Integer id,
            @RequestBody Schedule scheduleDetails) {
        try {
            Schedule updatedSchedule = scheduleService.updateSchedule(id, scheduleDetails);
            return ResponseEntity.ok(updatedSchedule); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    /**
     * DELETE /schedules/{id} - Eliminar un horario
     * @param id ID del horario a eliminar
     * @return 204 No Content si se eliminó, o 404 Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        try {
            scheduleService.deleteSchedule(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // ========================================
    // ENDPOINTS ADICIONALES (BONUS)
    // ========================================

    /**
     * GET /schedules/active - Obtener horarios activos
     * @return 200 OK con lista de horarios activos
     */
    @GetMapping("/active")
    public ResponseEntity<List<Schedule>> getActiveSchedules() {
        List<Schedule> schedules = scheduleService.getActiveSchedules();
        return ResponseEntity.ok(schedules); // 200 OK
    }

    /**
     * GET /schedules/inactive - Obtener horarios inactivos
     * @return 200 OK con lista de horarios inactivos
     */
    @GetMapping("/inactive")
    public ResponseEntity<List<Schedule>> getInactiveSchedules() {
        List<Schedule> schedules = scheduleService.getInactiveSchedules();
        return ResponseEntity.ok(schedules); // 200 OK
    }

    /**
     * GET /schedules/search?nombre={nombre} - Buscar por nombre
     * @param nombre Nombre del medicamento (búsqueda parcial)
     * @return 200 OK con lista de horarios encontrados
     */
    @GetMapping("/search")
    public ResponseEntity<List<Schedule>> searchByNombre(@RequestParam String nombre) {
        List<Schedule> schedules = scheduleService.searchByNombre(nombre);
        return ResponseEntity.ok(schedules); // 200 OK
    }

    /**
     * GET /schedules/hora/{hora} - Obtener horarios por hora específica
     * @param hora Hora en formato HH:mm (ej: "08:00")
     * @return 200 OK con lista de horarios para esa hora
     */
    @GetMapping("/hora/{hora}")
    public ResponseEntity<List<Schedule>> getSchedulesByHora(@PathVariable String hora) {
        List<Schedule> schedules = scheduleService.getSchedulesByHora(hora);
        return ResponseEntity.ok(schedules); // 200 OK
    }

    /**
     * GET /schedules/count/active - Contar horarios activos
     * @return 200 OK con el conteo de horarios activos
     */
    @GetMapping("/count/active")
    public ResponseEntity<Map<String, Long>> countActiveSchedules() {
        long count = scheduleService.countActiveSchedules();
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response); // 200 OK
    }

    /**
     * GET /schedules/health - Health check endpoint
     * @return 200 OK si la API está funcionando
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "API Horario Med");
        response.put("version", "2.0");
        return ResponseEntity.ok(response); // 200 OK
    }
}
