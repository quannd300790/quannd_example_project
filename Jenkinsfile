node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
    //def scannerHome = tool 'Sonar';
     def mvn = tool 'Maven';
     sh 'mvn clean test'
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
