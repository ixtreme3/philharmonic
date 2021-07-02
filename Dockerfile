FROM openjdk:16
MAINTAINER iXtreme3
ARG JAR_FILE=target/philharmonic-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} philharmonic.jar
ENTRYPOINT ["java","-jar","philharmonic.jar"]