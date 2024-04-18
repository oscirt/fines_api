#!/bin/bash

docker pull apache/kafka:3.7.0
docker run --name=kafka -p 9092:9092 apache/kafka:3.7.0
