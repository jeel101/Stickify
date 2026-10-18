# Match JAVA_VERSION to java.version in your pom.xml (17 or 21).
ARG JAVA_VERSION=17

FROM maven:3.9-eclipse-temurin-${JAVA_VERSION} AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q package -DskipTests

FROM eclipse-temurin:${JAVA_VERSION}-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Render sets PORT; the app reads it through server.port=${PORT:5000}.
ENTRYPOINT ["java", "-jar", "app.jar"]
