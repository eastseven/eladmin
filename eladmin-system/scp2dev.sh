#!/usr/bin/env bash

source ~/.profile

mvn clean package -Dmaven.test.skip=true

#scp target/*.jar root@192.168.0.2:/data/workspace/opanda-server/admin.jar
scp target/*.jar root@47.99.99.255:/data/workspace/opanda-server-admin/admin.jar