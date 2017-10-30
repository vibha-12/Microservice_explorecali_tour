FROM maven:3.2-jdk-7-onbuild
CMD ["C:/Users/Administrator/workspace/Vibha2/Microservice_explorecali_tour.git/trunk/target" "-jar" "explorecaliTour-0.0.1-SNAPSHOT.jar"]
RUN ["/root/.m2/repository/com/example/ec/explorecaliTour/0.0.1-SNAPSHOT/" "-jar" "explorecaliTour-0.0.1-SNAPSHOT.jar"]
