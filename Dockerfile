CMD ./gradlew build

FROM roohoo/arm-openjdk:1.0
USER root

COPY /build/libs/SpringDatabase-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java"]
CMD ["-jar", "SpringDatabase-0.0.1-SNAPSHOT.jar"]

