job('NodeJS example') {
    scm {
        git('git://github.com/movarik/docker-demo.git') {  node ->
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

