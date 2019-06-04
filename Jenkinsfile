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
          sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=tw-ea -Dsonar.sources=. -Dsonar.host.url=http://13.229.142.108:9000 -Dsonar.login=bd6ad23c477cce8eda069a636cfd15552dfce45a -Dsonar.exclusions=vendor/**,public/**,e2e/**,tests/**,Test-Automation/**"
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
