-- =========================================
-- INSERCIONES - parcial_db
-- =========================================
USE parcial_db;

-- =========================================
-- 5 REGISTROS DE PRUEBA
-- =========================================
INSERT INTO schedules (nombre, dosis, hora, frecuencia, notas, activo) VALUES
('Vitamina C', '1000mg', '08:00', 'Diario', 'Tomar con el desayuno para mejor absorción', TRUE),
('Paracetamol', '500mg', '08:00', 'Cada 8 horas', 'Tomar con alimentos para evitar molestias estomacales', TRUE),
('Ibuprofeno', '400mg', '09:00', 'Cada 12 horas', 'Evitar con el estómago vacío. Antiinflamatorio', TRUE),
('Amoxicilina', '1g', '07:00', 'Cada 8 horas', 'Antibiótico - completar tratamiento de 7 días', TRUE),
('Omeprazol', '20mg', '07:30', 'Diario', 'Antes del desayuno. Protector gástrico', TRUE)
ON DUPLICATE KEY UPDATE
nombre = VALUES(nombre),
dosis = VALUES(dosis),
hora = VALUES(hora),
frecuencia = VALUES(frecuencia),
notas = VALUES(notas),
activo = VALUES(activo);
