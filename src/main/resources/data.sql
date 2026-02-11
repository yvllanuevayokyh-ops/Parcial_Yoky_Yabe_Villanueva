-- ===============================================
-- DATOS DE PRUEBA PARA LA TABLA SCHEDULES
-- ===============================================
-- Estos datos se cargarán automáticamente al iniciar la aplicación

INSERT INTO schedules (nombre, dosis, hora, frecuencia, notas, activo) VALUES
('Paracetamol', '500mg', '08:00', 'Cada 8 horas', 'Tomar con alimentos', true),
('Ibuprofeno', '400mg', '09:00', 'Cada 12 horas', 'Evitar con el estómago vacío', true),
('Amoxicilina', '1g', '07:00', 'Cada 8 horas', 'Antibiótico - completar tratamiento', true),
('Vitamina D', '1000 UI', '08:00', 'Diario', 'Tomar con el desayuno', true),
('Omeprazol', '20mg', '07:30', 'Diario', 'Antes del desayuno', true),
('Losartán', '50mg', '20:00', 'Diario', 'Control de presión arterial', true),
('Metformina', '850mg', '12:00', 'Cada 12 horas', 'Con las comidas principales', true),
('Aspirina', '100mg', '21:00', 'Diario', 'Anticoagulante', true),
('Loratadina', '10mg', '22:00', 'Diario', 'Antihistamínico', false),
('Salbutamol', '2 puff', '06:00', 'Según necesidad', 'Inhalador para asma', true);
