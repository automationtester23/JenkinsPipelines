def repo_url
try{
    node{
        try{
            stage('Create a Directory'){
                sh 'mkdir -p GitClone'
            }
        }
        catch(Exception e){
            echo "Caused Exception in Stage \"Create a Directory\" :  "+ e.getMessage()
            error("Pipeline Failed Due to "+ e.getMessage())
        }

        try{
            stage('git clone'){
                dir('GitClone'){
                    repo_url = env.GITBASEURL+"/"+REPO_NAME+".git"
                    echo "The URL of Repository to be checkout is " + repo_url
                    echo "The branch to be checkout is " + BRANCH
                    checkout([$class: 'GitSCM', branches: [[name: BRANCH]], userRemoteConfigs: [[url: repo_url ]]])
                }
                sh 'cd GitClone;ls -lrtha'
            }
        }
        catch(Exception e){
            echo "Caused Exception in Stage \"git clone\" :  "+ e.getMessage()
            error("Pipeline Failed Due to "+ e.getMessage())
        }
    }
}
catch(Exception e){
    echo "Caued Exception:  "+ e.getMessage()
    error("Pipeline Failed Due to "+ e.getMessage())
}