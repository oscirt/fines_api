FROM mysql:8.3.0

ENV MYSQL_ROOT_PASSWORD=oscirt
ENV MYSQL_DATABASE=gibdd
ENV MYSQL_USER=oscirt
ENV MYSQL_PASSWORD=12345

COPY init.sql /docker-entrypoint-initdb.d/
