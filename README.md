# Topera's Hello World #022
## Parallel tests with Java 8
This hello world shows how to run parallel code on Java 8.

## How to use this source code
* Use the `Clone or download` button above the get the url of this repository
* In IntelliJ IDEA: File → New → Project From Version Control → Git → put the url of this repository

## How to test
* $ ./gradlew --info
* Note: adjust the memory settings changing "maxHeapSize" on build.gradle file 

## Our program
Our program will create millions instances of class User.
Then will do these steps on each user:
* Add a random age for he/she
* Mark the user as a kid, if the age is <= 12 years
* Finally, will count how many users are kids.
    * If your processor is correct, you should have ~12% of kids, since the highest age is 100 years. If you see a number "far" from 12, you have a problem in your JVM or processor :)

## Current results
* Machine: Vostro: Quad-core - Intel® Core™ i5-2410M Processor Launched Q1 2011 (2 physical cores vs 2 = 4 cores)

Output:
TODO

Notes
* The parallel execution is faster than sequential (~3.5x times)
        * However, there is a cost to split "tasks" to processors. So, we should try to centralize to have just one parallelStream call.
* If we remove the slow operation ("calculateMagicNumbers") the sequential is always faster than parallel


## Conclusions
* Parallel streams are useful only if:
    * You have a very big list of elements/array (like 1 million instances)
    * You have a costly operation to do on each element

## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index

