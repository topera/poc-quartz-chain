# Topera's Hello World #023 - IN PROGRESS 
## GPU tests with Java + Aparapi 
This hello world shows how to use GPU (your amazing Graphics Card!) in your Java projects.
It uses [Aparapi](http://aparapi.com) library to send commands to GPU (which uses OpenCL internally).
Don't worry, you don't need to write any C code, just Java :)

## How to use this source code
* Use the `Clone or download` button above the get the url of this repository
* In IntelliJ IDEA: File → New → Project From Version Control → Git → put the url of this repository

## How to test
* Required hardware: machine with 16GB RAM + GPU. However, you can change the number of instances on the test file  if you have less memory.
* Install Java, open a terminal and run
    * $ ./gradlew
* Note: adjust the memory settings changing "maxHeapSize" on build.gradle file 

## Lessons Learned
While doing this project, I learned that...
* **Discovery #1**: we need to install a Linux package (**ocl-icd-opencl-dev**) on local machine, otherwise will not work
* **Discovery #2**: in case of error accessing GPU the Aparapi library will automatically fallback to *parallelStream()* implementation (will use many cores of your CPU, not your GPU)
* **Discovery #3**: you CANNOT use GPU to run different unit tests on parallel. GPU can be used only to run THE SAME operation on many GPU cores. You can have different **data**, but not different processor **instructions**.
* **Discovery #4**: in the current Aparapi implementation you cannot use Java objects neigther call methods. We can only use primitive types: int, long, etc.

## Our program
TODO

## Current results
TODO

## Problems with GPU
To use the GPU you need to have **OpenCL** installed in your machine.
In my Ubuntu I just needed to run:

    sudo apt update
    sudo apt install ocl-icd-opencl-dev

If you don't install it, probably you will see this error:

    GRAVE: Check your environment. Failed to load codegen native library  or possibly failed to locate opencl native library (opencl.dll/opencl.so). Ensure that OpenCL is in your PATH (windows) or in LD_LIBRARY_PATH (linux).

## Conclusions
TODO

## Tech Stack
* Intellij IDEA 2019.3
* Gradle 4.10.3
* Java 8

To take a look in other projects, please see https://github.com/topera/index

