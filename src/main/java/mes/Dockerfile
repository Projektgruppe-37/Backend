FROM openjdk:15-alpine
ARG JAR_FILE=*.jar
EXPOSE 4840
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]