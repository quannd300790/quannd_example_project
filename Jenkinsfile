node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
    def scannerHome = tool 'Sonar';
     def mvnHome = tool 'Maven';
    withSonarQubeEnv('Sonar') {
     // sh "${scannerHome}/bin/sonar-scanner"
      sh "${mvnHome}/bin/mvn sonar:sonar"
    }
  }
}
