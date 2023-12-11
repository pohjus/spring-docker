FROM alpine:latest

EXPOSE 8080

# Copy everything from your project directory to 
# a folder called app. Basically copies Main.java
COPY . /app

# Move into that directory
WORKDIR /app

# Install Java 17, maven
RUN apk update && apk add openjdk17 maven

RUN mvn compile

# mvn spring-boot:run
CMD ["mvn", "spring-boot:run"]

