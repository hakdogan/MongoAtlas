#!/usr/bin/env bash
#mvn clean install
docker build -t mongoatlas .
docker run -d --rm --name atlas -p 8080:8080 mongoatlas