def call() {

stage('Download Latest Snapshot WAR') {
            steps {
                configFileProvider([configFile(fileId: 'aa6e5af3-b7b5-4c85-a784-24b381b1708a', variable: 'MAVEN_SETTINGS')]) {
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
