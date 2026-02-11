-- =========================================
-- BASE DE DATOS: parcial_db (AIVEN)
-- =========================================
USE parcial_db;

-- =========================================
-- TABLA: schedules
-- =========================================
CREATE TABLE IF NOT EXISTS schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dosis VARCHAR(50) NOT NULL,
    hora VARCHAR(5) NOT NULL,
    frecuencia VARCHAR(50) NOT NULL,
    notas TEXT,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_activo (activo),
    INDEX idx_hora (hora)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
