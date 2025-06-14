# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar compilado al contenedor
COPY target/ms04-api-rest-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que utiliza la aplicación(opcional)
EXPOSE 8083

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
