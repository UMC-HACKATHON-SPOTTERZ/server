FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} snapspot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/snapspot-0.0.1-SNAPSHOT.jar"]