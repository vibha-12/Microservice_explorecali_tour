pipeline {
    
    
        git url: "https://github.com/vibha-12/Microservice_explorecali_tour.git", credentialsId: 'lalta69vibha@gmail.com'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "your-project-name"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
   
}
