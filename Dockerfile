FROM openjdk:8-jdk-alpine
COPY ./target/azuretest-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
RUN sh -c "touch azuretest-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["java", "-Dcom.amazon.speech.speechlet.servlet.timestampTolerance=150", "-Dcom.amazon.speech.speechlet.servlet.supportedApplicationIds=amzn1.ask.skill.4bd2b5bd-9e6b-4a8f-9315-07c4ba308fb7", "-jar", "azuretest-0.0.1-SNAPSHOT.jar"]