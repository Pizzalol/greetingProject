# Greeting project

Greeting project is a simple REST project that greets the user with various greetings

# Requirements

  - Java 11
  - Docker 3.0+
  - Maven 3.6+

# Starting the project

You can start the project by building it yourself or by using/building the docker image. The image is available at pizzalol/greeting-project

### Building your own image

To build your own image, start Docker and your terminal (Windows PowerShell in case you are on a Windows OS). Relocate to the root directory of the project and run the following command:
```sh
docker build -t [NAME]/[TAG] .
```
Here is an example:
```sh
docker build -t pizzalol/greeting-project .
```

### Running the docker image

To run the image simply run:
```sh
docker run -p [PORT] -t [NAME]/[TAG]
```
Example run:
```sh
docker run -p 8080:8080 -t pizzalol/greeting-project
```

The greeting application should now be available at localhost:8080/greeting

### Building the project from source

To build the project from source then simply import the project into your desired IDE and run it as:
```sh
mvn package
```
If you want to skip tests during the build period then add the '-DskipTests' argument, like this:
```sh
mvn package -DskipTests
```

Execute this command to start the project:
```sh
mvn spring-boot:run
```

or if you want to start the application using a different profile then run it like this:
```sh
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

# Configuration properties

The project has three different profiles available: dev, prod and test. The default profile is dev.

| Property | Active value | Default value | Note |
| -------- | ------------ | ------------- | ---- |
| spring.profiles.active | dev | | Currently active configuration profile. |
| greeting.user.greeting | Hello | | The used greeting when normal greeting mode is active. |
| greeter.mode | timeBasedGreeting | normalGreeting | Greeting mode, normalGreeting and timeBasedGreeting are the two currently available modes. |