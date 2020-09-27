FROM openjdk:latest

RUN mkdir -p /opt/app
COPY build/install /opt/app
RUN ls -lrt /opt/app

CMD /opt/app/groovy-game-of-life/bin/groovy-game-of-life