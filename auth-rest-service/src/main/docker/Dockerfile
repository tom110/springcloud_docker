FROM hub.c.163.com/tom110/jdk8:slim

VOLUME /tmp
ADD auth-rest-service.jar app.jar
RUN sh -c 'touch /app.jar'
#EXPOSE 8761
ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]