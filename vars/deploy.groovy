def call() {

    stage('Build & Push to Artifactory') {
            steps {
                configFileProvider([configFile(fileId: 'aa6e5af3-b7b5-4c85-a784-24b381b1708a', variable: 'MAVEN_SETTINGS')]) {
                    sh '''
                    echo "🔨 Building & pushing to Artifactory..."
                    mvn clean deploy -s $MAVEN_SETTINGS
                    '''
                }
            }
}
}
