# Integration test example with

* [Mountebank](http://www.mbtest.org/)
* [Rest-Assured](http://rest-assured.io/)
* [Hamcrest](http://hamcrest.org/)
* [OpenFeign](https://github.com/OpenFeign/feign)
* [Spring boot integration test](https://spring.io/guides/gs/testing-web/)

### Context
This is a base example that shows how to create integration test with spring boot + (hamcrest as matching library
, rest-assured as MockMvcClientWrapper in gherkin expresion/language and mountebank as test-double engine).

The application is using an external service/rest-api that returns a simple json message.
 As Http client am i using OpenFeign. The layers are: resource&rarr;service&rarr;feignClient.

Basically the app would think that is using the original external/feign service/api but actually is using with Mountebank.
And in order to do that we need to run first the Mountebank engine (in my case i'm using docker-compose).

### How to test
```
    docker-compose up
    mvn clean test  
```
### Requirements
* JDK 8
* Maven 3
* Docker-compose 1.25.5

