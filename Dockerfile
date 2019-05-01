FROM openjdk:8
VOLUME /tmp
COPY target/software2project-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"]