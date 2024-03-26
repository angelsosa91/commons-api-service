# Person Core Service

[![pipeline status](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/badges/master/pipeline.svg)](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/-/commits/master)
[![coverage report](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/badges/master/coverage.svg)](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/-/commits/master)
[![Latest Release](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/-/badges/release.svg)](http://gitlab.solar.com.py/bancadigital/core/commons-api-service/-/releases)

Responsible for managing people data

## Getting Started

These instructions will help you to running on your local machine for development and testing purposes.

## Pre-requirements

- [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Docker (optional)](https://www.docker.com/get-started)

## Running with gradle

This project is built using gradle to build JAR files, execute tests and run the application local. Like some commands
as follows:

#### Build project:

```shell
$ ./gradlew build
```

#### Run tests:

```shell
$ ./gradlew test
```

#### Generate JAR file:

```shell
$ ./gradlew bootJar
```

#### Run the application:

```shell
$ ./gradlew bootRun
```

## Running with Docker (optional)

To run the application over a container, just install docker and run the follow

#### Generate JAR file:

```shell
$ ./gradlew clean bootJar
```

#### Create docker image:

```shell
$ docker build -t solar/commons-api-service .
```

#### Run the container:

```shell
$ docker run -p 8080:8080 --name commons-api-service solar/commons-api-service
```

## Built With

* [Spring Boot](https://spring.io/) - The web framework used
* [Gradle](https://docs.gradle.org/) - Dependency Management


