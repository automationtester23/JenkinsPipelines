try{
    node("slave01"){
        stage("Print Hello Word"){
            println("Sumedh Shinde")
            echo 'Sumedh Shinde Rocks'
        }
    }
}
catch(Exception e){
    echo "Exception Occured in Stage \"Print Hello World\" " + e.getMessage()
    error("Pipeline Stopped")
}
