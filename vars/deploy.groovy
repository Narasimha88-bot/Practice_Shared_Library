def call() {
    stage('Build & Push to Artifactory') {
        // Use pipeline steps directly, no "steps {}"
        configFileProvider([configFile(fileId: 'f0b88328-4641-4449-a033-39621f26353b', variable: 'MAVEN_SETTINGS')]) {
            sh '''
                echo "🔨 Building & pushing to Artifactory..."
                mvn clean deploy -s $MAVEN_SETTINGS
            '''
        }
    }
}
