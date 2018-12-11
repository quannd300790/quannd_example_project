node
{   
    def mvnHome
    mvnHome = tool 'maven'
    stage('Clean') {
        sh 'sudo rm -rf *'
    }
    stage('Checkout') {
     
       checkout scm

       sh "echo pending e2e testing"
     }
   
       
}


