#!/bin/bash
# =========================================
# SCRIPT DE BUILD Y RUN CON DOCKER
# =========================================

echo "🚀 API Horario Med - Docker Build & Run"
echo "========================================"

# Construir imagen Docker
echo "📦 Construyendo imagen Docker..."
docker build -t apihorariomed:latest .

if [ $? -eq 0 ]; then
    echo "✅ Imagen construida exitosamente"
    
    # Ejecutar contenedor
    echo "🏃 Ejecutando contenedor..."
    docker run -d \
        --name apihorariomed \
        -p 8080:8080 \
        -e SPRING_PROFILES_ACTIVE=prod \
        apihorariomed:latest
    
    if [ $? -eq 0 ]; then
        echo "✅ Contenedor iniciado exitosamente"
        echo ""
        echo "📍 API disponible en: http://localhost:8080"
        echo "🩺 Health check: http://localhost:8080/schedules/health"
        echo ""
        echo "📊 Ver logs: docker logs -f apihorariomed"
        echo "🛑 Detener: docker stop apihorariomed"
        echo "🗑️  Eliminar: docker rm apihorariomed"
    else
        echo "❌ Error al ejecutar el contenedor"
        exit 1
    fi
else
    echo "❌ Error al construir la imagen"
    exit 1
fi
