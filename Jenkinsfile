pipeline{
    agent any
    environment{
        registry= 'barayathel/pipeline-example'
        dockerHubCreds = 'dock-access'
        dockerImage =''
    }
    stages{
        
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
