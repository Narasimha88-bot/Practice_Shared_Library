def call() {

    stage('Checkout') {
        echo 'Checking out source code...'

        git branch: 'main',
            url: 'https://github.com/Narasimha88-bot/Practice_Shared_Library.git'
    }
}
