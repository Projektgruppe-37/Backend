FROM openjdk:15-alpine
ARG JAR_FILE="BreweryMES-1.0-SIMULATION.jar"
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]