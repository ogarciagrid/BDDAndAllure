FROM openjdk:8-jre-alpine

ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:NativeMemoryTracking=summary -Djava.security.egd=file:/dev/urandom" \
    SERVER_PORT=8080

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS" ]
