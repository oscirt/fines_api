#!/bin/bash

docker build -t gibdddb .
docker run --name=gibdddb -d -p 6603:3306 gibdddb
