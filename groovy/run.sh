#!/bin/bash

docker run --attach STDOUT --name gol-groovy gol-groovy:latest
CONTAINER_ID=$(docker container ls --all | grep "gol-groovy" | awk '{print $1}')
docker container rm $CONTAINER_ID