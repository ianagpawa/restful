# RESTFUL API
##### Java Spring Boot restful web service.

## Download source code.
Clone repo: `git clone https://github.com/ianagpawa/restful.git`

## Local Development
### Prerequesites
#### Windows
Install `Java 11 SE` :
* [Download OpenJDK for Java SE 11](https://jdk.java.net/)
    * Create Java folder in `C:\Program Files`.
    * Extract contents of downloaded openjdk11 folder.
    * Copy `jdk-11` folder to `C:\Program Files\Java`.
    * Set Java PATH `C:\Program Files\Java\jdk-11\bin`.
* [Reference for installation instructions](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html)

Install `Gradle`:
* [Installation instructions](https://gradle.org/install/)

### Dependencies
* Spring Web
* Spring Data JPA
* H2 Database
* Spring Boot Actuator 

## Build project
In terminal, navigate to folder director and use the following command to build the project:
```
gradle build
```

## Clean build
In terminal, navigate to folder director and use the following command to perform a clean build of the project:
```
gradle clean build
```

## Run service locally
In terminal, navigate to folder director and use the following command to run the service locally on port `8080`.
```
gradle bootRun
```

### Retrieve all quotes
```
curl -v localhost:8080/quotes
```
### Retrieve random quote
```
curl -v localhost:8080/random
```
### Retrieve quote by id
```
curl -v localhost:8080/quotes/{id}
```
### Add new quote
```
curl -X POST localhost:8080/quotes -H 'Content-type:application/json' -d '{"name": "{name}", "content": "{content}", "source": "{source}"}'
```
### Update quote
```
curl -X PUT localhost:8080/quotes/{id} -H 'Content-type:application/json' -d '{"name": "{name}", "content": "{content}", "source": "{source}"}'
```
### Delete quote
```
curl -X DELETE localhost:8080/quotes/{id}
```

## Creator

**Ian Agpawa**
 agpawaji@gmail.com