FROM jenkins/jenkins
COPY target/iRecipeNew-0.0.1-SNAPSHOT.jar app.jar
RUN curl -L "https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && chmod +x /usr/local/bin/docker-compose
USER jenkins


#FROM adoptopenjdk/openjdk11:alpine-jre
#ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
#RUN chmod +x /wait
#ENTRYPOINT /wait && java -jar app.jar

FROM openjdk:8-jre-alpine

RUN mkdir /app

COPY *.jar /app/app.jar

CMD java -jar /app/app.jar

