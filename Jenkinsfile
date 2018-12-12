node
{	
stage ('freestyle - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '${sha1}']],
	   doGenerateSubmoduleConfigurations: false, extensions: [], 
	   submoduleCfg: [], userRemoteConfigs: 
	   [[credentialsId: 'ddbe810d-af3f-4b1b-a21d-6320184efab5', 
	   url: 'https://github.com/quannd300790/quannd_example_project.git']]]) 
	}

stage('Test') {
echo HelloWorld
}

}