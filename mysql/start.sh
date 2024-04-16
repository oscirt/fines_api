#!/bin/bash

docker run --name=mysqldocker --restart on-failure -d -p 3306:3306 mysqldocker
