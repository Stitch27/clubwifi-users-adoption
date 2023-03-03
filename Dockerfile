FROM openjdk:8-jre-slim
VOLUME /tmp
EXPOSE 8185
ARG JAR_FILE=target/clubwifi-users-adoption-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} clubwifi-users-adoption.jar
ENTRYPOINT ["java","-jar","clubwifi-users-adoption.jar"]