English | [Portuguese](README.pt-br.md)

<h1 align="center">CheckpointAPI</h1>

<div align="center">

[![Java Version][java-src]][java-href]
[![Latest Commit][commit-src]][commit-href]
[![License][license-src]][license-href]

#### CheckpointAPI é um projeto desenvolvido com Spring Boot, para um Bootcamp da [Digital Innovation One](https://digitalinnovation.one/), com o objetivo de (WIP).

#### CheckpointAPI is a project developed with Spring Boot, Hibernate Envers, Lombok and Swagger for a Bootcamp from [Digital Innovation One](https://digitalinnovation.one/), with the objective of developing a Rest API for movement and access control of users in a company.

</div>

## How to use

First, clone this repository, access the directory and run the following command to execute the API:

```bash
$ ./gradlew bootRun
> Task :bootRun
   ___|   |                     |                     _)           |        \       _ \   _ _| |\ _ _
  |       __ \     _ \    __|   |  /   __ \     _ \    |   __ \    __|     _ \     |   |    |  | | \ \
  |       | | |    __/   (        <    |   |   (   |   |   |   |   |      ___ \    ___/     |   \ \ \ \
 \____|  _| |_|  \___|  \___|  _|\_\   .__/   \___/   _|  _|  _|  \__|  _/    _\  _|      ___|   ) ) ) )
         :: Spring Boot ::            _|               (v2.5.3)                                 / / / /
 ==============================================================================================/_/_/_/
```

From then on, the API should already be working. To check it, access the API documented in:

> http://localhost:8080/swagger-ui.html

Or to access the database management console, go to:

> http://localhost:8080/database/h2

Check the [application.yml](src/main/resources/application.yml) file to see the defined variables of the database. By default:

```yml
spring:
    datasource:
        url: jdbc:${database}:file:./.datasources/persona-api
        username: dbuser
        password:
```

The H2 database is initialized with some initial data that can be checked with Swagger or by accessing the [data.sql](src/main/resources/db/h2/data.sql) file.

[java-src]: https://img.shields.io/badge/java-11-orange
[java-href]: https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.12+7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi
[commit-src]: https://img.shields.io/github/last-commit/dio-projects/checkpoint-api
[commit-href]: https://github.com/dio-projects/checkpoint-api
[license-src]: https://img.shields.io/github/license/dio-projects/checkpoint-api
[license-href]: LICENSE