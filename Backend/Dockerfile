FROM maven:3.8.1-jdk-11 AS BUILD
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11
WORKDIR /app
COPY --from=BUILD /build/target/*.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar","demo-0.0.1-SNAPSHOT.jar"]