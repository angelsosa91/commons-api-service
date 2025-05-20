FROM registry.solar.com.py/library/openjdk:11.0.14-jre-slim

##application
COPY build/libs/commons-api-service*.jar /app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
EXPOSE 8080