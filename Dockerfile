FROM openjdk:8-jdk
EXPOSE 8082
ARG JAR_FILE=build/libs/RestApiIndividual-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]