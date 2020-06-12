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
                sh 'gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                sh "docker build --name duncanapi -t vimuens/translateapi ."
                sh "docker stop duncanapi"
                sh "docker start duncanapi"
            }
        }
    }
}