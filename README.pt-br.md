[English](README.md) | Portuguese

<h1 align="center">CheckpointAPI</h1>

<div align="center">

[![Java Version][java-src]][java-href]
[![Latest Commit][commit-src]][commit-href]
[![License][license-src]][license-href]

#### CheckpointAPI é um projeto desenvolvido com Spring Boot, para um Bootcamp da [Digital Innovation One](https://digitalinnovation.one/), com o objetivo de (WIP).

</div>

## Como usar

Primeiramente, clone este repositório, entre no diretório e execute o seguinte comando para rodar a API:

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

A partir disto o API já deve estar funcionando. Para verificar, pode ser acessada a API documentada em:

> http://localhost:8080/swagger-ui.html

Ou para ter acesso ao console do gerenciamento de banco de dados, acesse:

> http://localhost:8080/database/h2

Verifique o arquivo [application.yml](src/main/resources/application.yml) para ver as variáveis definidas para ter acesso ao banco de dados. Sendo por padrão:

```yml
spring:
    datasource:
        url: jdbc:${database}:file:./.datasources/persona-api
        username: dbuser
        password:
```

O banco de dados H2 é inicializado com alguns dados iniciais que podem ser verificados a partir do Swagger ou acessando o arquivo [data.sql](src/main/resources/db/h2/data.sql).

[java-src]: https://img.shields.io/badge/java-11-orange
[java-href]: https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.12+7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi
[commit-src]: https://img.shields.io/github/last-commit/dio-projects/checkpoint-api
[commit-href]: https://github.com/dio-projects/checkpoint-api
[license-src]: https://img.shields.io/github/license/dio-projects/checkpoint-api
[license-href]: LICENSE