FROM roohoo/arm-openjdk:1.0 AS build
USER root
CMD mkdir app
COPY * app/

CMD cd app
CMD chmod +x gradlew
CMD ./gradlew build
COPY . .
CMD chmod +x gradlew
RUN ./gradlew build

FROM roohoo/arm-openjdk:1.0
USER root

COPY --from=build /build/libs/*.jar .
ENTRYPOINT ["java"]
CMD ["-jar", "SpringDatabase-0.0.1-SNAPSHOT.jar"]

