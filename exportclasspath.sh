#!/usr/bin/sh

# export all neccessary classpath entries

basedir=$(pwd)

echo $basedir

# dependencies
vendor="$basedir/vendor"
junit="$vendor/hamcrest-core-1.3.jar:$vendor/junit-4.11.jar"
tools="$vendor/Tools.zip"

# dir for the package
oop="$basedir/src"

export CLASSPATH=".:$junit:$tools:$oop"