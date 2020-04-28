# Spring Boot #

Spring Boot is an open source Java-based framework used to create a Micro Service.

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

