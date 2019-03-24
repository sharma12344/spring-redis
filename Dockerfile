FROM openjdk:11
ADD ./target/spring-redis-example-0.0.1-SNAPSHOT.jar /usr/src/spring-redis-example-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "spring-redis-example-0.0.1-SNAPSHOT.jar"]