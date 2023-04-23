
FROM maven:3.6.3 AS build
COPY .. /car-dealerships
RUN mvn -f /car-dealerships/pom.xml clean package

#
FROM openjdk:17-slim
COPY --from=build /car-dealerships/target/car-dealerships-0.0.1-SNAPSHOT.jar /usr/local/lib/car-dealerships.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/car-dealerships.jar"]