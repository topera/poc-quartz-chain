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
On my Dell Vostro machine:

Output:

    Running SequentialTest
    *** Time taken: 5729ms *** 11.9754% of users are kids
    *** Time taken: 32ms *** 12.003900000000002% of users are kids
    *** Time taken: 39ms *** 12.0046% of users are kids
    *** Time taken: 39ms *** 11.984599999999999% of users are kids

    Running ParallelCPUTest
    *** Time taken: 1959ms *** 12.041699999999999% of users are kids
    *** Time taken: 107ms *** 12.0164% of users are kids
    *** Time taken: 102ms *** 12.030100000000001% of users are kids
    *** Time taken: 106ms *** 11.9785% of users are kids

Notes
* The parallel execution is faster than sequential (2.9x times)
    * The first execution is the most important because the other are biased because of branch-prediction and other optimizations.
* If we remove the slow operation ("calculateMagicNumbers") the sequential is always faster:

    Running SequentialTest
    *** Time taken: 58ms *** 12.0478% of users are kids
    *** Time taken: 33ms *** 11.9683% of users are kids
    *** Time taken: 40ms *** 12.0281% of users are kids
    *** Time taken: 39ms *** 12.0083% of users are kids

    Running ParallelCPUTest
    *** Time taken: 171ms *** 11.9694% of users are kids
    *** Time taken: 110ms *** 11.938500000000001% of users are kids
    *** Time taken: 114ms *** 11.948% of users are kids
    *** Time taken: 108ms *** 11.9666% of users are kids

* Machines:
    * Vostro: Quad-core - Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000


## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index



