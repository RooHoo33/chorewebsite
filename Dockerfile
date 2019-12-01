FROM roohoo/arm-openjdk:1.0 AS build
COPY /* .
CMD ls
CMD ./gradlew build

FROM roohoo/arm-openjdk:1.0
USER root

COPY --from=build /build/libs/*.jar .
ENTRYPOINT ["java"]
CMD ["-jar", "SpringDatabase-0.0.1-SNAPSHOT.jar"]

