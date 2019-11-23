# Topera's Hello World #022
## Parallel tests with Java 8
This hello world shows how to run parallel code on Java 8

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
* Finally, will count how many users are kids. If your processor is correct, you should have ~12% of kids, since the highest age is 100 years.
If you see a number "far" from 12, you have a problem in your JVM or processor :)

## Current results
On my Dell Vostro machine (quad-core):

Output:

    Running SequentialTest
    *** Time taken: 3598ms *** 11.9953% of users are kids
    *** Time taken: 4005ms *** 12.0319% of users are kids
    *** Time taken: 3693ms *** 12.0381% of users are kids
    *** Time taken: 3573ms *** 11.997% of users are kids

    Running ParallelCPUTest
    *** Time taken: 1251ms *** 11.988% of users are kids
    *** Time taken: 1331ms *** 12.0435% of users are kids
    *** Time taken: 1183ms *** 11.9491% of users are kids
    *** Time taken: 1173ms *** 12.0546% of users are kids

Notes
* The parallel execution is faster than sequential (2.9x times)
    * However, there is a cost to split "tasks" to processors. So, we should try to centralize to have just one parallelStream call.
* If we remove the slow operation ("calculateMagicNumbers") the sequential is always faster:

Output:

    Running SequentialTest
    *** Time taken: 42ms *** 12.0167% of users are kids
    *** Time taken: 28ms *** 11.9293% of users are kids
    *** Time taken: 22ms *** 11.95% of users are kids
    *** Time taken: 23ms *** 11.9614% of users are kids

    Running ParallelCPUTest
    *** Time taken: 112ms *** 12.000399999999999% of users are kids
    *** Time taken: 102ms *** 11.997399999999999% of users are kids
    *** Time taken: 94ms *** 12.0086% of users are kids
    *** Time taken: 93ms *** 12.0403% of users are kids

* Machines:
    * Vostro: Quad-core - Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000


## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index



