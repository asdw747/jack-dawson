#!/usr/bin/env bash
mvn -U clean install
scp ./target/jack-dawson-0.0.1-SNAPSHOT.jar root@182.61.61.203:~/