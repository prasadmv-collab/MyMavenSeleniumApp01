// pipeline {
//     agent any  // Use any available agent

//     tools {
//         maven 'Maven'  // Ensure this matches the name configured in Jenkins
//     }
//     stages {
//         stage('Checkout') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/akashsuresh2005/MySausedemo.git
//             }
//         }

//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'  // Run Maven build
//             }
//         }

//         stage('Test') {
//             steps {
//                 sh 'mvn test'  // Run unit tests
//             }
//         }

        
        
       
//         stage('Run Application') {
//             steps {
//                 // Start the JAR application
//                 sh 'java -jar target/MyMavenSeleniumApp_1-1.0-SNAPSHOT.jar'
//             }
//         }

        
//     }

//     post {
//         success {
//             echo 'Build and deployment successful!'
//         }
//         failure {
//             echo 'Build failed!'
//         }
//     }
// }
pipeline {
    agent any

    tools {
        // Double-check that 'Maven' is the name configured in your 
        // Jenkins 'Global Tool Configuration'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                // Fixed: Added the closing quote after .git
                git branch: 'main', url: 'https://github.com/akashsuresh2005/MySausedemo.git'
            }
        }

        stage('Build & Compile') {
            steps {
                // This ensures the code is valid and downloads dependencies
                sh 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                // For Selenium, 'mvn test' is the standard way to execute
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // This is important! It tells Jenkins where to find your 
            // Selenium test results so it can display them in the UI.
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Automation tests passed!'
        }
        failure {
            echo 'Pipeline failed. Check the Console Output or Test Reports.'
        }
    }
}
