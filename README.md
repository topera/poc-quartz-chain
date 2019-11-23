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

    Running ParallelCPUTest
    *** Time taken: 1187ms *** 12.0324% of users are kids
    *** Time taken: 1335ms *** 12.056899999999999% of users are kids
    *** Time taken: 1459ms *** 12.0448% of users are kids
    *** Time taken: 1209ms *** 11.9672% of users are kids

    Running SequentialTest
    *** Time taken: 3990ms *** 12.078999999999999% of users are kids
    *** Time taken: 3659ms *** 11.9939% of users are kids
    *** Time taken: 3574ms *** 11.9159% of users are kids
    *** Time taken: 3578ms *** 12.030100000000001% of users are kids

Notes
* The parallel execution is faster than sequential (~3.5x times)
    * However, there is a cost to split "tasks" to processors. So, we should try to centralize to have just one parallelStream call.
* If we remove the slow operation ("calculateMagicNumbers") the sequential is always faster:

Output:

    Running ParallelCPUTest
    *** Time taken: 78ms *** 11.9824% of users are kids
    *** Time taken: 92ms *** 12.0415% of users are kids
    *** Time taken: 89ms *** 11.991% of users are kids
    *** Time taken: 89ms *** 12.0239% of users are kids

    Running SequentialTest
    *** Time taken: 24ms *** 12.023200000000001% of users are kids
    *** Time taken: 20ms *** 11.9948% of users are kids
    *** Time taken: 16ms *** 11.9628% of users are kids
    *** Time taken: 16ms *** 11.9509% of users are kids

* Machines:
    * Vostro: Quad-core - Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000

## Conclusions
* Parallel streams are useful only if:
    * You have a very big list of elements/array (like 1 million instances)
    * You have a costly operation to do on each element

## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index



