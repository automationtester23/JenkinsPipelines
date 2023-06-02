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
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'git@github.com:automationtester23/APIDesigns.git']]])
                }
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