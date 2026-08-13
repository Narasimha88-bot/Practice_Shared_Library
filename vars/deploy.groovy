def call() {

    stage('Deploy') {
        echo 'Deploying application...'

        configFileProvider([
            configFile(
                fileId: 'ba1cfde0-e4e7-4537-8b4a-e05c48350215',
                variable: 'MAVEN_SETTINGS'
            )
        ]) {
            sh 'mvn deploy -s "$MAVEN_SETTINGS"'
        }
    }
}