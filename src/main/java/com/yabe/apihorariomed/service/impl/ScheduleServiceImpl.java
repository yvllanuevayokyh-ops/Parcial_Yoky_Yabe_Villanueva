package com.yabe.apihorariomed.service.impl;

import com.yabe.apihorariomed.model.Schedule;
import com.yabe.apihorariomed.repository.ScheduleRepository;
import com.yabe.apihorariomed.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de horarios de medicamentos
 * 
 * @author YABE
 * @version 1.0
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> getScheduleById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        // Por defecto, los nuevos horarios están activos
        if (schedule.getId() == 0) {
            schedule.setActivo(true);
        }
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Integer id, Schedule scheduleDetails) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));

        // Actualizar campos
        schedule.setNombre(scheduleDetails.getNombre());
        schedule.setDosis(scheduleDetails.getDosis());
        schedule.setHora(scheduleDetails.getHora());
        schedule.setFrecuencia(scheduleDetails.getFrecuencia());
        schedule.setNotas(scheduleDetails.getNotas());
        schedule.setActivo(scheduleDetails.isActivo());

        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        scheduleRepository.delete(schedule);
    }

    @Override
    public List<Schedule> getActiveSchedules() {
        return scheduleRepository.findByActivoTrue();
    }

    @Override
    public List<Schedule> getInactiveSchedules() {
        return scheduleRepository.findByActivoFalse();
    }

    @Override
    public List<Schedule> searchByNombre(String nombre) {
        return scheduleRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Schedule> getSchedulesByHora(String hora) {
        return scheduleRepository.findByHora(hora);
    }

    @Override
    public long countActiveSchedules() {
        return scheduleRepository.countByActivoTrue();
    }
}
