FROM maven:3.2-jdk-8-onbuild
VOLUME /tmp
ADD explorecaliTour-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

