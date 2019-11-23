# Topera's Hello World #022
## Parallel tests with Java 8
This hello world shows how to run parallel code on Java 8

## How to use this source code
* Use the `Clone or download` button above the get the url of this repository
* In IntelliJ IDEA: File → New → Project From Version Control → Git → put the url of this repository

## How to test
* $ ./gradlew --info
* Note: adjust the memory settings changing "maxHeapSize" on build.gradle file 


## Current results
On my machine the parallel execution is *worst*:
* Sequential: 80ms
* Parallel: 104ms (*30%* worst)

Machine:
* Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000

Output:

    Running SequentialTest
    *** Time taken: 112ms *** 12.00719% of users are kids
    *** Time taken: 80ms *** 12.00197% of users are kids
    *** Time taken: 80ms *** 11.99763% of users are kids
    *** Time taken: 80ms *** 11.98675% of users are kids
    
    Running ParallelTest
    *** Time taken: 109ms *** 11.99686% of users are kids
    *** Time taken: 107ms *** 11.99337% of users are kids
    *** Time taken: 103ms *** 12.00327% of users are kids
    *** Time taken: 104ms *** 11.99693% of users are kids

## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index



