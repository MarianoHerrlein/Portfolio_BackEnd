FROM amazoncorretto:8-alpine-jdk   

MAINTAINER marianoherrlein

COPY target/MiPortfolio-0.0.1-SNAPSHOT.jar  MiPortfolio-app.jar 

ENTRYPOINT ["java","-jar","/MiPortfolio-app.jar"]