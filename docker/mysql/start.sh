#!/bin/bash

docker build -t finesmysql .
docker run --name=finesmysql -d -p 3306:3306 finesmysql
