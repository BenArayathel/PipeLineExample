pipeline{
    agent any
    environment{
        registry= 'barayathel/pipeline-example'
        dockerHubCreds = 'dock-access'
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
		stage("Deploy to production"){
            steps{
                script{
  
                    sh 'echo $registry:$currentBuild.number'
                    sh "kubectl set image -n ben-space deployment/pipeline-deployment micrometer-demo-deploymen$registry:$currentBuild.number"
              
                }
            }
        }
		
    }
}
