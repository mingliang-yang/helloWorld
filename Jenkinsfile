pipeline {
    agent any
//     tools {
//         maven 'M39'
//         jdk 'JDK17'
//     }
    environment {
        IMAGE_NAME = "springboot-hello"
        IMAGE_TAG = "v1.0"
    }
    stages {
        stage('拉取代码') {
            steps {
                git url: '你的 Git 仓库地址', branch: 'main'
            }
        }
        stage('Maven 打包') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('构建 Docker 镜像') {
            steps {
                bat 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }
        stage('推送镜像（可选）') {
            steps {
                bat 'kind load docker-image ${IMAGE_NAME}:${IMAGE_TAG}'
            }
        }
        stage('部署到 K8s') {
            steps {
                bat 'kubectl apply -f k8s-deployment.yaml'
                bat 'kubectl apply -f k8s-service.yaml'
            }
        }
    }
}