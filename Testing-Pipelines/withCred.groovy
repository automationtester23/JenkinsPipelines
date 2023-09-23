try{
    node("master"){
        stage('git clone'){
            def base_path="${env.BASE_PATH}jenkins/${JOB_NAME}"
            sh("mkdir -p ${base_path}")
            dir(base_path){
                withCredentials([usernamePassword(credentialsId: 'GitHub_user',usernameVariable: 'GIT_USERNAME',passwordVariable: 'GIT_PASSWORD')]){
                    sh 'git clone https://'+GIT_USERNAME+':'+GIT_PASSWORD+'@github.com/automationtester23/jenkins-dir'
                }
            }
        }
    }
}catch(Exception ex){
    println("inside 1st catch block")
    println("Error : ${ex.getMessage()}")
}     