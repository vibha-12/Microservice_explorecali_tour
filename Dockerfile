FROM maven:3.2-jdk-8
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn install
RUN bash -c 'touch /explorecaliTour-0.0.1-SNAPSHOT.jar'
HEALTHCHECK --timeout=10s --interval=1000s --retries=3 CMD curl -s --fail http://localhost:4041/tours || exit 1
ENTRYPOINT ["java","-jar","usr/src/app/target/explorecaliTour-0.0.1-SNAPSHOT.jar"]
CMD ["java" , "-jar" ,"usr/src/app/target/explorecaliTour-0.0.1-SNAPSHOT.jar"]
