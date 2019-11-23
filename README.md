# Topera's Hello World #022
## Parallel tests with Java 8
This hello world shows how to run parallel code on Java 8.
And **YES** it will use your amazing Graphics Card game to run the tests :)

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
On my Dell Vostro machine (quad-core, with embedded GraphicsCard):

Output:

    Running SequentialTest
    *** Time taken: 4120ms *** 11.9742% of users are kids
    *** Time taken: 4088ms *** 12.0716% of users are kids
    *** Time taken: 4035ms *** 11.9463% of users are kids
    *** Time taken: 4036ms *** 11.9709% of users are kids

    Running ParallelCPUTest
    *** Time taken: 1178ms *** 12.0086% of users are kids
    *** Time taken: 1322ms *** 11.9767% of users are kids
    *** Time taken: 1241ms *** 11.9913% of users are kids
    *** Time taken: 1141ms *** 11.9903% of users are kids

    Running ParallelGraphCardTest
    *** Time taken: 1260ms *** 11.9888% of users are kids
    *** Time taken: 1162ms *** 11.9867% of users are kids
    *** Time taken: 1147ms *** 12.0291% of users are kids
    *** Time taken: 1148ms *** 12.019% of users are kids

Notes
* Comparing sequential with parallel (CPU)
    * The parallel execution is faster than sequential (~3.5x times)
        * However, there is a cost to split "tasks" to processors. So, we should try to centralize to have just one parallelStream call.
    * If we remove the slow operation ("calculateMagicNumbers") the sequential is always faster than parallel

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
    
* Comparing CPU with GPU
    * The times of parallels execution (CPU and GPU) are the same. Probably because I don't have a dedicated graphic board here :(

* Machines:
    * Vostro: Quad-core - Intel® Core™ i5-2410M Processor Launched  Q1 2011 2 2.90 GHz  2.30 GHz  3 MB SmartCache Intel® HD Graphics 3000

## Conclusions
* Parallel streams are useful only if:
    * You have a very big list of elements/array (like 1 million instances)
    * You have a costly operation to do on each element

## Problems with Graphics Card (GPU)
To run the GPU test you need to have **OpenCL** installed in your machine.
In my Ubuntu I just needed to run:

    sudo apt update
    sudo apt install ocl-icd-opencl-dev

If you don't install it, probably you will see this error:

    GRAVE: Check your environment. Failed to load codegen native library  or possibly failed to locate opencl native library (opencl.dll/opencl.so). Ensure that OpenCL is in your PATH (windows) or in LD_LIBRARY_PATH (linux).

In case of error the [Aparapi](http://aparapi.com/) library automatically fallsback to *parallelStream()* implementation,
as we can see in the output times:

    Running ParallelGraphCardTest
    *** Time taken: 1240ms *** 12.0365% of users are kids
    *** Time taken: 1137ms *** 12.0254% of users are kids
    *** Time taken: 1140ms *** 12.058399999999999% of users are kids
    *** Time taken: 1141ms *** 12.0432% of users are kids

## Tech Stack
* Intellij IDEA 2019.2
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index

