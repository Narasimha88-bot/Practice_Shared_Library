def call() {

    stage('Build & Push to Artifactory') {
            steps {
                configFileProvider([configFile(fileId: '324d7939-2b89-4485-a851-1a9f0ead8bd5', variable: 'MAVEN_SETTINGS')]) {
                    sh '''
                    echo "🔨 Building & pushing to Artifactory..."
                    mvn clean deploy -s $MAVEN_SETTINGS
                    '''
                }
            }
}
}
