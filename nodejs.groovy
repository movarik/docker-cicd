job('NodeJS example') {
    scm {
        git('https://github.com/movarik/docker-cicd.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@domain.com')
        }
    }
    triggers { 
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps { 
        shell("npm install")
    }
}

