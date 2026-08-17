def call() {

 stage('Install') {
            steps {
                sh 'mvn clean install'
            }
        }
}
