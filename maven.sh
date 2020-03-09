#!/bin/bash


install() {
  mvn install:install-file \
    -Dfile=target/tasdik-1.7.7.1.jar \
    -DgroupId=com.github.enesusta \
    -DartifactId=tasdik \
    -Dversion=1.8.0.7 \
    -Dpackaging=jar
}

mvn clean package
install
