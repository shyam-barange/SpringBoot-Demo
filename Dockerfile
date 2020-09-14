FROM openjdk:8
EXPOSE 8085
ADD target/springboot-mongodb.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]