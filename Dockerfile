FROM ghcr.io/graalvm/jdk-community:21

##application
COPY build/libs/commons-api-service*.jar /app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
EXPOSE 8080
