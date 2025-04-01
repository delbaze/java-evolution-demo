#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <java-version>"
    echo "Example: $0 8"
    exit 1
fi

VERSION=$1

# Construire l'image
podman build -f Dockerfile-java$VERSION -t java$VERSION-demo .

# Convertir le chemin Windows en format compatible avec Podman
# Cette ligne gère la conversion du chemin pour qu'il fonctionne dans Git Bash sur Windows
CURRENT_DIR=$(pwd -W 2>/dev/null || pwd | sed 's/^\///' | sed 's/\//\\/g' | sed 's/^./\0:/')
SOURCE_PATH="/$(pwd -W 2>/dev/null || echo $CURRENT_DIR | sed 's/\\/\//g' | sed 's/://')/src"

# Exécuter le conteneur avec le chemin correct
podman run --rm -it -v "${SOURCE_PATH}:/app/src:z" java$VERSION-demo