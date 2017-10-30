FROM maven:3.2-jdk-8
VOLUME /tmp
CMD ["mvn" "install"]
ADD target/explorecaliTour-0.0.1-SNAPSHOT.jar user.jar
RUN bash -c 'touch /user.jar'
HEALTHCHECK --timeout=10s --interval=1000s --retries=3 CMD curl -s --fail http://localhost:4041/tours || exit 1
ENTRYPOINT ["java","-jar","/user.jar"]
CMD ["java" , "-jar" ,"/user.jar"]
 
