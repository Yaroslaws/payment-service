# Этап 1: Сборка проекта с помощью Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Указываем рабочую директорию
WORKDIR /app

# Копируем файлы проекта
COPY pom.xml .
COPY src ./src

# Собираем проект и пропускаем тесты для ускорения
RUN mvn clean package -DskipTests

# Этап 2: Минимальный образ только с JAR-файлом
FROM openjdk:21-jdk-slim as builder

# Указываем рабочую директорию
WORKDIR /app

# Копируем jar-файл из предыдущего этапа
COPY --from=build /app/target/payment-service-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
