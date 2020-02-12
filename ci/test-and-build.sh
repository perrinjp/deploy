#!/usr/bin/env bash

set -e -u -
cd source-code-from-github/
./mvnw clean package

cd ..
cp -rf source-code-from-github/target/springboot-concourse-0.0.5-SNAPSHOT.jar resource-gist/springboot-concourse-0.0.5-SNAPSHOT.jar
cd ../resource-gist
git config --global user.email "jeanpaul.perrin@cgi.com"
git config --global user.name "JPP"
git add .
git commit -m "update jar springboot-concourse-0.0.5-SNAPSHOT.jar"