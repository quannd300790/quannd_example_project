pipeline {
  agent any
  stages {    
    
     stage('SCM') {
       steps {
          checkout scm
       }
   
  }
    
    stage('Test') {
      steps{
        def mvnHome = tool 'Maven'
    
     sh "${mvnHome}/bin/mvn clean test"
      }
     
  }
    
  }
  post {
    always {
      echo 'Hello!'
          
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
    }
  }
}
