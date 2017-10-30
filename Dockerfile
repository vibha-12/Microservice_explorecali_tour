FROM maven:3.2-jdk-7-onbuild
CMD ["C:/Users/Administrator/workspace/Vibha2/Microservice_explorecali_tour.git/trunk/target" "-jar" "explorecaliTour-0.0.1-SNAPSHOT.jar"]
RUN ["/usr/src/app/" "-jar" "target/explorecaliTour-0.0.1-SNAPSHOT.jar"]
