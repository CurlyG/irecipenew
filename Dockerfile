FROM jenkins/jenkins
COPY target/iRecipeNew-0.0.1-SNAPSHOT.jar app.jar
RUN curl -L "https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && chmod +x /usr/local/bin/docker-compose
USER jenkinsnew
