// Custom string interpolation function for <> placeholders
def customInterpolateWithAngleBrackets(String input, Map<String, Object> variables) {
    // Regular expression to match <variable> placeholders
    def pattern = /<([^>]+)>/

    // Use a closure to perform the replacement
    def result = input.replaceAll(pattern) { match ->
        def variableName = match[1]
        println("variableName: ${variableName}")
        if (variables.containsKey(variableName)) {
            println("variables[variableName].toString() : ${variables[variableName].toString()}")
            return variables[variableName].toString()

        } else {
            // Handle cases where the variable doesn't exist (optional)
            println("match: ${match}")
            return match
        }
    }

    return result
}

node("master"){
    stage("git clone"){
        def base_path="${BASE_PATH}/jenkins/${JOBNAME}"
        sh("mkdir -p ${base_path}")
        dir(base_path){
            def repo_url= "${env.GITBASEURL}/JenkinsPipelines.git"
            checkout([$class: 'GitSCM',branches: [name: 'develop']],userRemoteConfigs: [[url: repo_url]])
            sh('ls -lrth')
        }
    }
    stage("test"){
        // Example usage
        def input = "Hello, <name>! Today is <day>."
        def variables = ["name": "Alice", "day": "Monday"]
        def interpolatedString = customInterpolateWithAngleBrackets(input, variables)
        println(interpolatedString)
    }
}

