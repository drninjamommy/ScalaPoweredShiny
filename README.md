
| Project       | Created   | Updated   | Version |
|---------------|-----------|-----------|---------|
| Shiny RESTful | 15/5/2017 | 17/5/2017 | 0.2     |

# Overview

Demonstration of using a R Shiny Dashboard calling a Scala RESTful API (http4s).

# http4s

Generate an http4s service on the blaze backend with Circe.

1.  `sbt run`
2.  `curl http://localhost:8080/data/rocks`
3.  `curl http://localhost:8080/data/pressure`
4.  `curl http://localhost:8080/data/cars`

*   I've created a POSTMAN document in the resources folder to enable easy of testing.

Repo created using the http4s template located [here](https://github.com/http4s/http4s.g8)

### Endpoints

The API provide four endpoints:

1. cars => [http://localhost:8000/data/cars](http://localhost:8000/data/cars)
2. pressure => [http://localhost:8000/data/pressure](http://localhost:8000/data/pressure)
3. rock => [http://localhost:8000/data/rock](http://localhost:8000/data/rock)
4. Yet to be defined

See the [README.md](PythonRESTful/README.md) file in the Python RESTful folder

# Shiny Dashboard

Three files are used to create the Dashboard:

1.  a script to define the user interface (ui.R)
2.  a script to set the server that responds to UI actions and displays the charts (server.R)
3.  a supporting file that creates variables and functions that are globally available to bother the server and UI scripts (global.R).

### Heroku API Running

I've been meaning to try the Heroku services for a while. Firstly, wow. So simple!

Launch at Heroku API using the basic (tutorial)[https://devcenter.heroku.com/articles/getting-started-with-scala#introduction].

Simple instructions and minimal amount of commands to get up and running:

```
    heroku create
    git push heroku master
```

The only gotchas were that I needed to a build.properties file, plugins.sbt file to the project folder and the method of capturing the PORT from heroku. 

### Running the Dashboard

Features:

*   GET requests
*   Authentication (Basic)
*   POST request

Simply open any of the file R files; server, ui or global. Once open you will see a "Run" icon in the upper right hand side of the script pane, click that option.

Adjacent to the "Run" icon is a dropdown, select "Run External" before running.

See the [README.md](ShinyRESTful/README.md) file in the Python RESTful folder
