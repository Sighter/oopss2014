#!/usr/bin/sh

# export all necessary classpath entries
# to use this script run
# 
# $ source exportclasspath.sh
# 
# from the project root directory or set the basedir
# correctly

basedir=$(pwd)

echo $basedir

# dependencies
vendor="$basedir/vendor"
junit="$vendor/hamcrest-core-1.3.jar:$vendor/junit-4.11.jar"
tools="$vendor/Tools.zip"

# dir for the package
oop="$basedir/src"

export CLASSPATH=".:$junit:$tools:$oop"