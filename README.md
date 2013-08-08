
<h1>VISUALGO</h1>
***
### Get project:
```
$ git clone git://github.com/jhilary/visualgo.git
$ cd visualgo/trunk
```
***
### Console build & run

#### Build and run in batch mode:
```
$ mvn package -Pbatch
$ java -jar target/visualgo-0.0.1-SNAPSHOT.jar
```
#### Build and run in webapp mode:
```
$ mvn package -Pwebapp
$ java -jar target/dependency/jetty-runner.jar target/visualgo-0.0.1-SNAPSHOT.war
```
In browser: http://127.0.0.1:8080/main/mincut/algos.do
***
### Eclipse build & run

File &rarr; Import &rarr; Existing Maven Project  
Run as &rarr; Maven build.. &rarr; [set goal "package"]  
Run as &rarr; Java Application &rarr; [choose Main]  
```
$ mvn jetty:run
```
In browser: http://127.0.0.1:8080/visualgo/main/mincut/algos.do 


