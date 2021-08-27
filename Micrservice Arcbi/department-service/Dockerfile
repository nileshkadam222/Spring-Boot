FROM java:8
EXPOSE 9001
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} department-service.jar
ENTRYPOINT ["java","-jar","/department-service.jar"]
