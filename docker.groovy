job('NodeJS Docker example') {
    scm {
        git('https://github.com/movarik/docker-cicd.git', 'master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('jmovarik/nodejs1-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('movarik-docker-hub')
	    buildContext("basics")
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}


