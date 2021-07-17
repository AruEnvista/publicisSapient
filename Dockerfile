FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ADD target/work-0.0.1-SNAPSHOT.jar work.jar
ENTRYPOINT ["java", "-jar", "/work.jar"]