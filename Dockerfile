FROM amazoncorretto:8-al2-jdk

MAINTAINER marianoherrlein

COPY target/MiPortfolio-0.0.1-SNAPSHOT.jar MH-app.jar

ENTRYPOINT ["java","-jar","/MH-app.jar"]