FROM openjdk:11.0.5-jre-slim

EXPOSE 9000

ADD /target/qcm-matrix-0.0.1-SNAPSHOT.jar qcm-matrix-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","qcm-matrix-0.0.1-SNAPSHOT.jar"]