#!/bin/sh

set -e -x

if [ "$#" -ne 1 ]; then
    echo "Please provide location to place build output."
    exit 1;
fi

./mvnw package
cp target/articulate-0.0.1-SNAPSHOT.jar $1
