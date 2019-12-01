#FROM roohoo/arm-openjdk:1.0 AS build
#USER root
#CMD mkdir app
#COPY * app/
#
#CMD cd app
#CMD ./gradlew build
#COPY . .
#RUN ./gradlew build

FROM roohoo/arm-openjdk:1.0
USER root

COPY build/libs/*.jar .
ENTRYPOINT ["java"]
CMD ["-jar", "SpringDatabase-0.0.1-SNAPSHOT.jar"]

