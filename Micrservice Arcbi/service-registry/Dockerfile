FROM java:8
EXPOSE 8761
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-registry.jar
ENTRYPOINT ["java","-jar","service=registry,jar"]