FROM amazoncorretto:11-alpine-jdk
MAINTAINER MH
COPY target/MiPortfolio-0.0.1-SNAPSHOT.jar  mh-app.jar
ENTRYPOINT ["java","-jar","/mh-app.jar"]