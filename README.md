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
* Machine: DELL Vostro 3550 - Intel® Core™ i5-2410M (2 * 2 physical cores = **4 cores**)

Output:

    Running SequentialTests
    *** Time taken: 8160ms *** 12.01855% of users are kids
    *** Time taken: 8046ms *** 12.0059% of users are kids
    *** Time taken: 7078ms *** 12.01% of users are kids
    *** Time taken: 7059ms *** 12.0132% of users are kids

    Running ParallelCPUTest
    *** Time taken: 2428ms *** 11.96315% of users are kids
    *** Time taken: 2409ms *** 12.02005% of users are kids
    *** Time taken: 2307ms *** 11.97705% of users are kids
    *** Time taken: 2368ms *** 11.9984% of users are kids

Gradle Test Executor 2 finished executing tests.


* Machine: DELL G5 15 5590 - Intel® Core™ i7-9750H (Max frequency: 4.5 GHz, 2 * 6 physical cores = **12 cores**)

Output:

    Running SequentialTest
    *** Time taken: 6206ms *** 11.989700000000001% of users are kids
    *** Time taken: 6192ms *** 11.9964% of users are kids
    *** Time taken: 6178ms *** 11.9871% of users are kids
    *** Time taken: 6186ms *** 11.99715% of users are kids

    Running ParallelCPUTest
    *** Time taken: 652ms *** 11.98715% of users are kids
    *** Time taken: 719ms *** 11.99125% of users are kids
    *** Time taken: 636ms *** 11.957049999999999% of users are kids
    *** Time taken: 637ms *** 12.04115% of users are kids



Notes
* As expected, the parallel execution is faster than sequential. However, there is a cost to split "tasks" to processors. So, we should try to centralize to have just one parallelStream call.
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

