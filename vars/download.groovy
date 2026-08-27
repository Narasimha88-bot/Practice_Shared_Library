def call() {


stage('Download Latest Snapshot WAR and deploy to Tomcat') {
 
                configFileProvider([configFile(fileId: 'f0b88328-4641-4449-a033-39621f26353b', variable: 'MAVEN_SETTINGS')]) {
                    sh '''
                    echo "📦 Downloading latest snapshot WAR..."
                    mvn -s $MAVEN_SETTINGS org.apache.maven.plugins:maven-dependency-plugin:3.7.0:copy \
                        -Dartifact=com.example:sample-webapp:1.2-SNAPSHOT:war \
                        -DoutputDirectory=/tmp \
                        -Dtransitive=false

                    LATEST_WAR=$(ls -t /tmp/sample-webapp-1.2-*.war | head -1)
                    echo "Latest WAR file: $(basename $LATEST_WAR)"
                    sudo cp $LATEST_WAR /opt/tomcat/tomcat-11/webapps/
                    sudo systemctl restart tomcat
                    '''
                }
            }
}
   
