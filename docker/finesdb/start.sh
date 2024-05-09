#!/bin/bash

docker build -t finesdb .
docker run --name=finesdb -d -p 3306:3306 finesdb
