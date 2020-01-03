# Topera's Hello World #024
## Jackson XML 
This hello world shows how to use Jackson XML to marshal/serialize objects to XML (and vice-versa)

## How to use this source code
* Use the `Clone or download` button above the get the url of this repository
* In IntelliJ IDEA: File → New → Project From Version Control → Git → put the url of this repository

## Notes
* We dont need ANY annotation on our model classes. However, we are using *@JacksonXmlElementWrapper*
and *@JsonProperty* just to have different names for **cars** and **car** xml elements.
By default, we got **cars** inside **cars** element,
instead of **car** inside **cars**.

* It's better to use constructors **without** parameters, since they are REQUIRED on unmarshall process.
In our example we need to create 2 constructors on Customer class: ours (receiving name) and the required
by Jackson (with no parameters)

## How to test
* Install Java, open a terminal and run
    * $ ./gradlew

## Tech Stack
* Intellij IDEA 2019.3.1
* Gradle 6.0.1
* Java 8

To take a look in other projects, please see https://github.com/topera/index

