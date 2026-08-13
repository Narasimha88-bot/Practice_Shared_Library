def call() {

    stage('Checkout') {
        echo 'Checking out source code...'

        git branch: 'main',
            url: 'https://github.com/devops002026-web/SampleWebApplication.git'
    }
}