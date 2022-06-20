pipeline{
    agent any
    environment{
        registry= 'barayathel/pipeline-example'
        dockerHubCreds = 'dockerhub'
        dockerImage =''
    }
    stages{
        stage("Maven clean package"){
            steps{
                sh 'echo $M2_HOME'
                sh 'echo $PATH'
                sh '/usr/local/apache-maven/bin/mvn clean package'
            }
        }
        stage("Docker build"){
            steps{
                script{
                    dockerImage = docker.build "$registry"
                }
            }
        }
        stage("Sending image to DockerHub"){
            steps{
                script{
                    docker.withRegistry('', dockerHubCreds){
                        dockerImage.push("$currentBuild.number")
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }
}