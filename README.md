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
On my machine the parallel execution is **3.7x** *slower*! - running for 30 million users.
* Sequential: 791ms
* Parallel: 2940ms

Machine:
* Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000

Output:

    Running ParallelCPUTest
    *** Time taken: 3149ms *** 12.007966666666666% of users are kids
    *** Time taken: 2940ms *** 11.998656666666667% of users are kids
    *** Time taken: 3322ms *** 11.988616666666667% of users are kids
    *** Time taken: 3197ms *** 11.999033333333333% of users are kids

    Running SequentialTest
    *** Time taken: 844ms *** 12.00889% of users are kids
    *** Time taken: 816ms *** 11.998356666666666% of users are kids
    *** Time taken: 791ms *** 12.008803333333333% of users are kids
    *** Time taken: 802ms *** 12.002943333333334% of users are kids


## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index



