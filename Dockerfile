FROM openjdk:11
VOLUME /tmp
COPY /target/SpringBootMavenExample-1.3.5.RELEASE.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]