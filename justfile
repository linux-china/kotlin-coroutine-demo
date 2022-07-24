#!/usr/bin/env just --justfile

# build project
build:
  ./gradlew -x test build

update:
   ./gradlew dependencyUpdate > ./updates.txt

dependencies:
  ./gradlew -q dependencies --configuration compileClasspath > ./dependencies.txt