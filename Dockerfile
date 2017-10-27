FROM maven:3.2-jdk-8-onbuild
HEALTHCHECK --timeout=10s --interval=1000s --retries=3 CMD curl -s --fail http://localhost:4041/tours || exit 1
RUN mvn install
ENTRYPOINT ["java","-jar","target/explorecaliTour-0.0.1-SNAPSHOT.jar"]
CMD ["C:\Users\Administrator\workspace\Vibha2\Microservice_explorecali_tour.git\trunk" , "-jar" ,"target/explorecaliTour-0.0.1-SNAPSHOT.jar"]
