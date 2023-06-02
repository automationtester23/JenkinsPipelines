try{
    node{
        stage("Print Hello Word")
    }
}
catch(Exception e){
    println(e.getMessages)
}