pipeline {
    agent { dockerfile true}
    
    stages{
        stage('Step 1'){
            agent any 
            steps {
                sh 'docker build -t barayathel/planetapiv2:latest .'
            }
        }

     }
}
