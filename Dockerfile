FROM openjdk:18-oracle
COPY target/banner-category-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]