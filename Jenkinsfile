pipeline {
  agent none
  environment {
    // DOCKERHUBNAME = "liker163"
    CONTAINERNAME = "seatabusiness"
    IMAGENAME = "liker163/tbusiness"
  }
  stages {
    stage('maven Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn -B -DskipTests clean package'
        // sh 'mvn package -Dmaven.test.skip=true'
        // sh 'mvn clean package'
      }
    }

    stage('docker build & push & run') {
      agent any
      steps {
        script {
          def REMOVE_FLAG_C = sh(returnStdout: true, script: "docker container ls -q --filter name=${CONTAINERNAME}") != ""
          echo "REMOVE_FLAG_C: ${REMOVE_FLAG_C}"
          if(REMOVE_FLAG_C){
            sh 'docker stop ${CONTAINERNAME}'
            sh 'docker rm ${CONTAINERNAME}'
          }
          def REMOVE_FLAG_I = sh(returnStdout: true, script: "docker image ls -q ${IMAGENAME}") != ""
          echo "REMOVE_FLAG_I: ${REMOVE_FLAG_I}"
          if(REMOVE_FLAG_I){
            sh 'docker image rmi ${IMAGENAME}'
          }
          sh 'docker image build -t ${IMAGENAME} .'
          sh 'docker run -d -p 8183:8183 --name ${CONTAINERNAME} ${IMAGENAME}'
        }
      }
    }

    stage('clean workspace') {
      agent any
      steps {
        // clean workspace after job finished
        cleanWs()
      }
    }
  }
}