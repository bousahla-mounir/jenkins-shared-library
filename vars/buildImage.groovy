#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t adabachir/demo-repo:jma-2.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push adabachir/demo-repo:jma-2.2'
    }
}