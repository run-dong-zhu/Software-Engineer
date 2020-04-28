# Spring Boot ##

Spring Boot is an open source Java-based framework used to create a Micro Service.

## Spring ##

Learning Spring is the prerequisite of Spring Boot.

Spring framework is an open source Java platform that provides comprehensive infrastructure support for developing robust Java applications very easily and very rapidly.

Spring is the most popular application development framework for enterprise Java.

### Benefits of using Spring Framework ###

- POJO Based - The benefit of using only POJOs is that you do not need an EJB container product such as an application server but you have the option of using only a robust servlet container such as Tomcat or some commercial product.

- Modular - Spring is organized in a modular fashion.

- Integration with existing frameworks - Spring use of some of the existing technologies like several ORM frameworks, logging frameworks, JEE, Quartz and JDK timers, and other view technologies.

- Testablity - Testing an application written with Spring is simple because environment-dependent code is moved into this framework. Furthermore, by using JavaBeanstyle POJOs, it becomes easier to use dependency injection for injecting test data.

- Web MVC - Spring's web framework is a well-designed web MVC framework, which provides a great alternative to web frameworks such as Struts or other over-engineered or less popular web frameworks.

- Central Exception Handling - Spring provides a convenient API to translate technology-specific exceptions (thrown by JDBC, Hibernate, or JDO, for example) into consistent, unchecked exceptions.

- Lightweight - Lightweight IoC containers tend to be lightweight, especially when compared to EJB containers, for example. This is beneficial for developing and deploying applications on computers with limited memory and CPU resources.

- Transaction management - Spring provides a consistent transaction management interface that can scale down to a local transaction (using a single database, for example) and scale up to global transactions (using JTA, for example).

## Getting Start ##

### AutoConfiguration ###

Spring Boot Auto Configuration automatically configures your Spring application based on the JAR dependencies you added in the project.

Spring Boot automatically configures your application based on the dependencies you have added to the project by using **@EnableAutoConfiguration** annotation.

*For example*, if MySQL database is on your classpath, but you have not configured any database connection, then Spring Boot auto-configures an in-memory database.

### Component Scan ###

Spring Boot application scans all the beans and package declarations when the application initializes. You need to add the **@ComponentScan** annotation for your class file to scan your components added in your project.

### Main Method ###

The main method should be writing the Spring Boot Application class. This class should be annotated with **@SpringBootApplication**. This is the entry point of the spring boot application to start. You can find the main class file under src/java/main directories with the default package.

```java
package com.helloworld.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
}
```

### Dependency Injection ###

In Spring Boot, we can use Spring Framework to define our beans and their dependency injection. The **@ComponentScan** annotation is used to find beans and the corresponding injected with **@Autowired** annotation.

If you followed the Spring Boot typical layout, no need to specify any arguments for **@ComponentScan annotation**. All component class files are automatically registered with Spring Beans.

### Logging ###

Spring Boot uses Apache Commons logging for all internal logging. Spring Boot’s default configurations provides a support for the use of Java Util Logging, Log4j2, and Logback. Using these, we can configure the console logging as well as file logging.

Log Format

- Date and Time that gives the date and time of the log
- Log level shows INFO, ERROR or WARN
- Process ID
- The --- which is a separator
- Thread name is enclosed within the square brackets []
- Logger Name that shows the Source class name
- The Log message

By default, all logs will print on the console window and not in the files. If you want to print the logs in a file, you need to set the property logging.file or logging.path in the application.properties file.

```yaml
logging.path = /var/tmp/
logging.file = /var/tmp/mylog.log
```

The code given below shows how to add the slf4j logger in Spring Boot main class file.
```java
package com.tutorialspoint.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
   private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
   
   public static void main(String[] args) {
      logger.info("this is a info message");
      logger.warn("this is a warn message");
      logger.error("this is a error message");
      SpringApplication.run(DemoApplication.class, args);
   }
}
```

### REST ###

Rest Controller

The **@RestController** annotation is used to define the RESTful web services. It serves JSON, XML and custom response.

```java
@RestController
public class ProductServiceController {
}
```

Request Mapping
The **@RequestMapping** annotation is used to define the Request URI to access the REST Endpoints. We can define Request method to consume and produce object. The default request method is GET.

```java
@RequestMapping(value = "/products")
public ResponseEntity<Object> getProducts() {
}
```

Request Body

The **@RequestBody** annotation is used to define the request body content type.

```java
public ResponseEntity<Object> createProduct(@RequestBody Product product) {
}
```

Path Variable

The **@PathVariable** annotation is used to define the custom or dynamic request URI. The Path variable in request URI is defined as curly braces {}

```java
public ResponseEntity<Object> updateProduct(@PathVariable("id") String id) {
}
```

Request Parameter

The **@RequestParam** annotation is used to read the request parameters from the Request URL. By default, it is a required parameter. We can also set default value for request parameters.

```java
public ResponseEntity<Object> getProduct(
   @RequestParam(value = "name", required = false, defaultValue = "honey") String name) {
}
```

### Exception Handle ###

The **@ControllerAdvice** is an annotation, to handle the exceptions globally.

The **@ExceptionHandler** is an annotation used to handle the specific exceptions and sending the custom responses to the client.

```java
@ExceptionHandler(value = ProductNotfoundException.class)

public ResponseEntity<Object> exception(ProductNotfoundException exception) {
}

