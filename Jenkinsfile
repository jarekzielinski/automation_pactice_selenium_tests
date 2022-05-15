pipeline {
    agent any
   stages {
        stage('Build test code') {
                     steps {
                         sh 'mvn clean install -DskipTests'
                     }
                 }
=======
    stages{
>>>>>>> origin/logging_v2
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
