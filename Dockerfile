#Distributable lightweight image for running the jar file
FROM openjdk:8-jre

COPY /target/PlanetAPIV2-0.0.1-SNAPSHOT-jar-with-dependencies.jar demo.jar

CMD ["java","-jar","demo.jar"]
