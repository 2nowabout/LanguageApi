pipeline {
    agent any
    tools {
        gradle 'Gradle'
        jdk 'JDK 8'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                echo "Running ${env.BUILD_ID} ${env.BUILD_DISPLAY_NAME} on ${env.NODE_NAME} and JOB ${env.JOB_NAME}"
                sh 'gradle clean jar'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'gradle test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                sh "docker stop duncanapi"
                sh "docker build -t vimuens/translateapi:${BUILD_NUMBER} ."
                sh "docker tag vimuens/translateapi:${BUILD_NUMBER} vimuens/translateapi:latest"
                sh "docker rm --force duncanapi"
                sh "docker run -d --name duncanapi -p 8086:8020 vimuens/translateapi:latest"
            }
        }
    }
}