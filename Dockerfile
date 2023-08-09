FROM eclipse-temurin:8-jdk-jammy

WORKDIR /app

# default value is in pom.xml
ARG WAR_FILE_PATH
ARG WAR_FILE_NAME

ENV WAR_FILE=${WAR_FILE_NAME}.war

COPY ${WAR_FILE_PATH} ./${WAR_FILE}

# RUN addgroup -S spring && adduser -S spring -G spring

# USER spring:spring

# VOLUME /tmp

EXPOSE 8082

# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", ${WAR_FILE}]
# must use "sh", "-c" for analysis ${WAR_FILE}
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar ${WAR_FILE}"]