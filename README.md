# 🧬 Intercorp Microservices Demo

Este repositorio contiene una arquitectura de microservicios dockerizada usando **Java 21 (Spring Boot 3.5.0)** para el backend y **Angular 20** para el frontend. La aplicación simula la gestión de registros de personas, transformaciones y exposición vía API REST, usando Apache Kafka y MySQL.

---

## 🏗️ Estructura del Proyecto

```
intercorp-ms/
├── intercorp-ui/                # Frontend Angular
├── ms01-kafka-consumer/        # Microservicio Kafka consumidor
├── ms02-kafka-transformer/     # Microservicio transformador Kafka
├── ms04-api-rest/              # API REST para exponer los datos
├── ms05-xml-producer/          # Productor de XML a Kafka
├── mysql/                      # Scripts de creación de BD/tablas
│   └── init.sql
├── docker-compose.yml          # Orquestación Docker
└── README.md                   # Archivo documentado para la ejecución
```

---

## 🚀 Cómo Ejecutar Localmente

### ✅ Requisitos
- Docker y Docker Compose instalados
- Puerto libre: `4200`, `8080`, `8081`, `8082`, `8083`, `3306`, `9092`

### ▶️ Paso a paso

1. Clona el repositorio:
```bash
git clone https://github.com/edwindelacruzramos/intercorp-ms.git
cd intercorp-ms
```

2. Ejecuta la construcción y levantamiento:
```bash
docker-compose build
docker-compose up -d
```

3. Verifica acceso:
- 🌐 Frontend Angular: [http://localhost:4200](http://localhost:4200)
- 📡 Backend API REST: [http://localhost:8083/api/persons](http://localhost:8083/api/persons)

---

## 💾 Bases de Datos Iniciales

Las siguientes bases de datos se crean automáticamente al iniciar el contenedor de `mysql`:

- `db_ms01_kafka`
- `db_ms04_kafka`

Estas incluyen las tablas necesarias: `person_record`, `person_elt`.

El script se encuentra en: `mysql/init.sql`.

---

## 📦 Tecnologías Usadas

| Componente     | Tecnología            |
|----------------|------------------------|
| Backend        | Spring Boot 3.5.0 + Java 21 |
| Frontend       | Angular 20             |
| Mensajería     | Apache Kafka 7.6.0     |
| Base de datos  | MySQL 8                |
| Infraestructura| Docker + Docker Compose|
| Otros          | Bootstrap 5, RxJS, XLSX|

---

## ✍️ Autor

- Edwin De La Cruz Ramos
- GitHub: [@edwindelacruzramos](https://github.com/edwindelacruzramos)

🗓️ Última actualización: 2025-06-14
