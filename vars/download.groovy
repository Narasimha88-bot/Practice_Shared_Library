def call() {

stage('Download Latest Snapshot WAR') {
            steps {
                configFileProvider([configFile(fileId: '324d7939-2b89-4485-a851-1a9f0ead8bd5', variable: 'MAVEN_SETTINGS')]) {
                    sh '''
                    echo "📦 Downloading latest snapshot WAR..."
                    mvn -s $MAVEN_SETTINGS org.apache.maven.plugins:maven-dependency-plugin:3.7.0:copy \
                        -Dartifact=com.example:sample-webapp:1.2-SNAPSHOT:war \
                        -DoutputDirectory=/tmp \
                        -Dtransitive=false

                    LATEST_WAR=$(ls -t /tmp/sample-webapp-1.2-*.war | head -1)
                    echo "Latest WAR file: $(basename $LATEST_WAR)"
                    '''
                }
            }
   }
}
