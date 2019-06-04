node
{   
    def mvnHome
    mvnHome = tool 'Maven'
    stage('Clean') {
        sh 'sudo rm -rf *'
    }
    stage('Checkout') {
     
       checkout scm
     }
   
    try{
     stage('Analys'){
        def scannerHome = tool 'Sonar';
        withSonarQubeEnv('Sonar') {
          sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=quannd -Dsonar.sources=. -Dsonar.host.url=http://localhost:9000 -Dsonar.login=e006561baa25f3ac8568e3f69d8f1cbcd5499ff2 -Dsonar.exclusions=src/**"
         }
        }    
    stage("Build"){            
            sh "echo pending Build"
        }
    stage('Test') {
                sh "echo pending e2e testing"
        } 
    }
    catch(all) {
        currentBuild.result = 'FAILURE'
    }     
}
