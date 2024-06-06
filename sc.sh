#!/bin/bash
mvn clean package

java -jar target/dbmanager.jar -u <user> -p <pass> -d localhost:3306/test -dbtype mysql -q query.sql

status=$?

if [ $status -ne 0 ]; then
    echo "oopsi -> Status: $status"
else
    echo "HOLA -> Status: $status"
fi

# Exit with the captured status
exit $status
