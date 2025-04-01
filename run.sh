#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <java-version>"
    echo "Example: $0 8"
    exit 1
fi

VERSION=$1

podman build -f Dockerfile-java$VERSION -t java$VERSION-demo .

podman run --rm -it java$VERSION-demo
