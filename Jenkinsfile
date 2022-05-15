pipeline {
    agent any
    environment{
    PATH="C:/apache-maven-3.8.3/bin:$PATH"
    }
   stages {
        stage('Build test code') {
                     steps {
                         sh 'mvn clean install -DskipTests'
                     }
                 }

    stages{
        stage('Execute test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
