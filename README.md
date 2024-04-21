# fortinet-audit Spring Boot application 

This repository contains a Spring Boot application for accepting audit message from microservices. It exposes APIs to store and get audit messages.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Docker (for running RabbitMQ in a Docker container)
- Maven (for building the application)

## RabbitMQ Setup

To run RabbitMQ in a Docker container, follow these steps:

1. Pull the RabbitMQ Docker image from Docker Hub by running the following command:

    ```
    docker pull rabbitmq:3-management
    ```

2. Once the image is downloaded, start a RabbitMQ container using the following command:

    ```
    docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```

3. RabbitMQ will now be accessible on `localhost:5672`. You can access the management UI by visiting `http://localhost:15672` in your web browser. The default credentials are `guest/guest`.

## Building and Running the Application

To build and run the Spring Boot application, follow these steps:

1. Clone this repository to your local machine:

    ```
    git clone https://github.com/virtualanuj/fortinet-audit.git
    ```

2. Navigate to the project directory:

    ```
    cd fortinet-audit
    ```

3. Build the application using Maven:

    ```
    mvn clean install
    ```

4. Once the build is successful, you can run the application using the following command:

    ```
    java -jar target/audit-service-0.0.1-SNAPSHOT.war
    ```

5. The application will start, and you can access it at `http://localhost:8080`.

## Docker Container

To build a Docker container for the application, follow these steps:

1. Ensure you have Docker installed and running on your machine.

2. Navigate to the project directory if you haven't already.

3. Build the Docker image using the provided Dockerfile:

    ```
    docker build -t audit-service .
    ```

4. Once the image is built, you can run a container using the following command:

    ```
    docker run -p 8080:8080 audit-service
    ```

5. The application will be accessible at `http://localhost:8080`.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues if you encounter any problems or have suggestions for improvement.

## License

This project is licensed under the [GLP-3.0](LICENSE).

---
