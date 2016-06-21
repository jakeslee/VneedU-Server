#!/bin/bash
echo `pwd`
REPO_DIR=./VneedU-Server
cd $REPO_DIR

function UPDATE_CODE() {
	git stash &&\
	git pull
}

function BUILD_START() {
	./gradlew :vneedu-service:assembleDist
}

function GET_VERSION() {
	cat build.gradle | awk '$1 ~ /version/{print $2}'
}

UPDATE_CODE
BUILD_START

VERSION=$(GET_VERSION | sed -e "s/^'//" -e "s/'$//")
Target=vneedu-service-$VERSION
ArchiveDir="./service/build/distributions/"$Target".zip"

unzip $ArchiveDir -d ./

cd ../
sh "$REPO_DIR/"$Target"/bin/vneedu-service"
