try{
    node{
        stage("Print Hello Word"){
            println("Sumedh Shinde")
            sh 'sumedh'
        }
    }
}
catch(Exception e){
    echo "Exception Occured in Stage \"Print Hello World\" " + e.getMessage()
    error("Pipeline Stopped")
}
