@Library("shared-library") _
def config =[]
try{
    node{
        stage("use helloWorld.groovy library Function"){
            config = [name: 'sumedh',dayOfWeek: "Saturday"]
            helloWorld(config)
        }
    }
}
catch(Exception e){
    error("caused Error in Pipelin : "+e.getMessage())
}