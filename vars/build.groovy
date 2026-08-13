def call() {

    stage('Build') {
        echo 'Building Java application...'

        sh 'mvn clean package -DskipTests'
    }
}