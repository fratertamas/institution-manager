FROM openjdk:8-jdk
COPY target/institution-manager-*.jar usr/src/institution-manager.jar
WORKDIR /usr/src/
ENTRYPOINT java -jar institution-manager.jar
