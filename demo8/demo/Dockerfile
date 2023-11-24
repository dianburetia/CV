FROM maven:3.8.3-openjdk-17 AS builder
COPY ./src/ /root1/src
COPY ./pom.xml /root1/
COPY ./checkstyle.xml /root1/
WORKDIR /root1
RUN mvn package
RUN java -Djarmode=layertools -jar /root1/target/demo-0.0.1-SNAPSHOT.jar list
RUN java -Djarmode=layertools -jar /root1/target/demo-0.0.1-SNAPSHOT.jar extract
RUN ls -l /root1
FROM openjdk:17-jdk-slim-buster
ENV TZ=UTC
ENV DB_IP=localhost
ENV DB_PORT=5432
ENV DB_USER=postgres
ENV DB_PASSWORD=parola
ENV DB_DBNAME=tema1SDDevices
COPY --from=builder /root1/dependencies/ ./
COPY --from=builder /root1/snapshot-dependencies/ ./
RUN sleep 10
COPY --from=builder /root1/spring-boot-loader/ ./
COPY --from=builder /root1/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher","-XX:+UseContainerSupport -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Xms512m -Xmx512m -XX:+UseG1GC -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m"]
