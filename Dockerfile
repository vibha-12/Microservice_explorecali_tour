FROM maven:3.2-jdk-8
VOLUME /tmp
COPY . C:\Users\Administrator\.m2\repository\com\example\New folder (3)\trunk
WORKDIR C:\Users\Administrator\.m2\repository\com\example\New folder (3)\trunk
CMD ["mvn" "install"]
EXPOSE 4041
HEALTHCHECK --timeout=10s --interval=1000s --retries=3 CMD curl -s --fail http://localhost:4041/tours || exit 1
ENTRYPOINT ["java","-jar","/explorecaliTour-0.0.1-SNAPSHOT.jar"]
CMD ["java" , "-jar" ,"/explorecaliTour-0.0.1-SNAPSHOT.jar"]
RUN ["java" , "-jar" ,"/explorecaliTour-0.0.1-SNAPSHOT.jar"]




