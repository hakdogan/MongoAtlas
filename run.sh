#!/usr/bin/env bash
mvn clean install
docker build --build-arg VERSION=1.0-SNAPSHOT -t mongoatlas .
docker run -d --rm --name atlas -p 8080:8080 mongoatlas