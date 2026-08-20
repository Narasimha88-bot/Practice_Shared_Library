def ()
{
   stage ('deploy_download_copytotomcat') {
        configFileProvider(configFile(fileId: '', variable: 'MAVEN_SETTNGS'))
        sh '''
        #deploying to the artifactory
        mvn clean deploy -s $MAVEN_SETTINGS
        # downloading the war file from artifactory
        mvn -s $MAVEN_SETTINGS org.apache.maven.plugins:maven-dependency-plugin:3.7.0:copy \
        -Dartifact=com.example:sample-webapp:1.2-SNAPSHOT:war \
        -DoutputDirectory=/tmp \
        -Dtransitive=false
        #Take the latest war file from the /tmp directory
        Latest_WAR=$(ls -t /tmp/sample-webapp-1.2-*.war | head -1)
        echo "Latest WAR file: $(basename $Latest_WAR)"
        #copying the war file to tomcat webapps directory
        cp $Latest_WAR /opt/tomcat/webapps/
        #Restart the tomcat service
        systemctl restart tomcat
        '''
    }
}