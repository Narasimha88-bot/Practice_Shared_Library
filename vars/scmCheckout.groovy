def call() {

    stage('Checkout') {
        echo 'Checking out source code...'

        git branch: 'main',
            url: 'https://github.com/Narasimha88-bot/jenkins_shared-Repository.git'
    }
}
