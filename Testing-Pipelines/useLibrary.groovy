@Library("shared-library") _
def config =[]
try{
    node("slave01"){
        stage("use helloWorld.groovy library Function"){
            config = [name: NAME,dayOfWeek: DAYOFWEEK]
            helloWorld(config)
        }
    }
}
catch(Exception e){
    error("caused Error in Pipelin : "+e.getMessage())
}