![Build
Status](https://travis-ci.org/hakdogan/MongoAtlas.svg?branch=master)
!["Codecove
Coverage](https://codecov.io/gh/hakdogan/MongoAtlas/branch/master/graph/badge.svg)
!["Docker
Pulls](https://img.shields.io/docker/pulls/hakdogan/mongoatlas.svg)
![](https://badges.gitter.im/MongoAtlas/Lobby.svg)

This application simply exemplifies working with MongoDB Stitch via
Mongo Atlas which is mongo cloud service.

What’s Mongo Atlas?
===================

MongoDB Atlas is a cloud-hosted MongoDB service engineered and it
abstract to the management of database, setup and configuration
processes from you. [Details](https://www.mongodb.com/cloud/atlas)

What’s MongoDB Stitch?
======================

MongoDB Stitch provides to full access to MongoDB, declarative
read/write controls and integration with your choice of services.
[Details](https://www.mongodb.com/cloud/stitch)

Run
===
````
mvn spring-boot:run
````

Run with Docker
===============
````
docker run -d --rm -p 8080:8080 hakdogan/mongoatlas
````

![](images/atlas.gif)

For this tutorial, I followed [Stitch
documentation](https://docs.mongodb.com/stitch/getting-started/first-stitch-app/)
to use the JavaScript Client example.
