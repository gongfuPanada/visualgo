<h1>VISUALGO</h1>
***
### Get project:
```bash
$ git clone git://github.com/jhilary/visualgo.git
```
***
### Console build & run

#### Build and run in batch mode:
```bash
$ mvn package -Pbatch  
$ java -jar target/visualgo-0.0.1-SNAPSHOT.jar
```
#### Build and run in webapp mode:
```bash
$ mvn package -Pwebapp
$ java -jar target/dependency/jetty-runner.jar target/visualgo-0.0.1-SNAPSHOT.war
```
In browser: http://127.0.0.1:8080
***
### Eclipse build & run

_File &rarr; Import &rarr; Existing Maven Project_  
_Run as &rarr; Maven build... &rarr; [set goal "package"]_  
_Run as &rarr; Java Application &rarr; [choose Main]_  
```bash
$ mvn jetty:run
```
In browser: http://127.0.0.1:8080/Visualgo

***
### Current build & deploy status:

[![Build Status](https://travis-ci.org/jhilary/visualgo.png)](https://travis-ci.org/jhilary/visualgo)  

[![Deploy status](https://logos.heroku.com/images/heroku-logo-light-88x31.png)](http://limitless-atoll-5463.herokuapp.com)

