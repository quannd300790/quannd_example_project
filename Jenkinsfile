pipeline {
    environment {
        //This variable need be tested as string
        doError = '1'
    }
   
    agent any
    
    stages {
        stage('Error') {
            when {
                expression { doError == '1' }
            }
            steps {
                echo "Failure"
                error "failure test. It's work"
            }
        }
        
        stage('Success') {
            when {
                expression { doError == '0' }
            }
            steps {
                echo "ok"
            }
        }
    }
    post {
        always {
            echo 'Hello!'
            
            emailext subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                to: 'quannd3007@gmail.com, quanndd3cntt@gmail.com',
            
            recipientProviders: [
                                     [$class: 'DevelopersRecipientProvider'], 
                                     [$class: 'RequesterRecipientProvider']
            ],
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"

        }
    }
}
