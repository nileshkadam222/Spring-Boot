FROM java:8
EXPOSE 9191
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cloud-gateway.jar
ENTRYPOINT ["java","-jar","cloud-gateway.jar"]

