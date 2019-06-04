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
      sh "${mvnHome}/bin/mvn clean test sonar:sonar -Dsonar.login=b08f2fcd894eada200df38ff08d04c86e6a4cb3e"
    }
    
    jacoco sourcePattern: '**/src/test/java'
  }
}
