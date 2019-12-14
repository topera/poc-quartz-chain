# Topera's Hello World #023 - IN PROGRESS 
## GPU tests with Java + Aparapi 
This hello world shows how to use GPU (your amazing Graphics Card) in your Java projects!

## How to use this source code
* Use the `Clone or download` button above the get the url of this repository
* In IntelliJ IDEA: File → New → Project From Version Control → Git → put the url of this repository

## How to test
* Install Java, open a terminal and run
    * $ ./gradlew
* Note: adjust the memory settings changing "maxHeapSize" on build.gradle file 

## Lessons Learned
While doing this project, I learned that...
* **Discovery #1**: you CANNOT use GPU to run different unit tests on parallel. GPU can be used only to run THE SAME operation on many GPU cores. You can have different **data**, but not different processor **instructions**.
* **Discovery #2**: in the current [Aparapi](http://aparapi.com) implementation you cannot use Java objects neigther call methods. We can only use primitive types: int, long, etc.

## Our program
TODO

## Current results
TODO

## Conclusions
TODO

## Tech Stack
* Intellij IDEA 2019.3
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index

