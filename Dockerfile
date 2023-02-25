FROM --platform=linux/amd64 openjdk:19

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY  ./build/libs/JavaSpring-0.0.1-SNAPSHOT.jar .


ENTRYPOINT ["java","-jar","/usr/src/app/JavaSpring-0.0.1-SNAPSHOT.jar"]

