FROM registry.solar.com.py/library/openjdk:11.0.14-jre-slim

##application
COPY build/libs/commons-api-service*.jar /app.jar
##certificates
COPY cert/solar.com.py.crt /solar.com.py.crt
##import keytool
RUN keytool -import -storepass "changeit" -noprompt -keystore $JAVA_HOME/lib/security/cacerts -alias solarPyCert2024 -file /solar.com.py.crt

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
EXPOSE 8080