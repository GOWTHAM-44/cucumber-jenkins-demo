pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn -B clean test'
            }
        }

        stage('Generate Maven Report') {
            steps {
                sh 'mvn -B surefire-report:report'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml, target/cucumber-reports/*.xml',
                  allowEmptyResults: true

            publishHTML(target: [
                reportName: 'Cucumber HTML Report',
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber.html',
                keepAll: true
            ])

            publishHTML(target: [
                reportName: 'Maven Surefire Report',
                reportDir: 'target/site',
                reportFiles: 'surefire-report.html',
                keepAll: true
            ])

            archiveArtifacts artifacts: 'target/**/*.html, target/**/*.json, target/**/*.xml',
                             fingerprint: true
        }
    }
}