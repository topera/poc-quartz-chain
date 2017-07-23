# Topera's Hello World #002
## Gradle Rest JAX-RS Hello World
This hello world is a Rest Client and a Rest Server at same time.

How to test
* $ gradle war
* get generated war from build/libs/gradle-rest-jaxrs-hello-world-1.0.war and deploy it.
* Access: http://localhost:8080/api/playlist

Rest Server
* This example creates this service endpoint: http://localhost:8080/api/playlist

Rest Client
* This example connects to Deezer API to download some playlist info.

Tech Stack
* Intellij IDEA 2016.1.4
* Gradle 3.5.1
* Java 8

