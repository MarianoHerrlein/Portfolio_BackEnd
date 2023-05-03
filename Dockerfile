FROM amazoncorretto:11

MAINTAINER marianoherrlein

COPY target/MiPortfolio-0.0.1-SNAPSHOT.jar MH-app.jar

ENTRYPOINT ["java","-jar","/MH-app.jar"]