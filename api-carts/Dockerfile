FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY ./build/libs/api-carts-1.0.jar application.jar

# Debug
# ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999"
ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -jar application.jar
