FROM openjdk:17-jdk-alpine
WORKDIR /app
ENV MONGO_HOST=localhost
ENV POSTGRES_HOST=localhost
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]