# Integrating Elasticsearch in Spring Boot

This project demonstrates how to integrate Elasticsearch functionality with a Spring Boot application, leveraging Docker for a seamless Elasticsearch setup.

## Prerequisites

Before you begin, ensure that you have the following installed:

- **Docker**: For running Elasticsearch in a container.
- **Java**: To run the Spring Boot application.
- **Maven**: For managing project dependencies (if using Maven).
- **Postman** (or any API testing tool): To test the REST endpoints.

## Steps to Get Started

### 1. Clone the Project

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/aditya-8-88/Integrating-ElasticSearch-in-SpringBoot.git
```

### 2. Install Docker for Your Operating System

If you don't have Docker installed, follow the official installation guide for your operating system:

- Docker Installation for Windows
- Docker Installation for Mac
- Docker Installation for Linux

### 3. Run Elasticsearch Using Docker

In this project, Elasticsearch is configured to run on port 9200. If you don't have Elasticsearch installed, you can easily run it using Docker by following these steps.

#### 3.1 Pull the Elasticsearch Docker Image

First, pull the official Elasticsearch Docker image by running:

```bash
sudo docker pull docker.elastic.co/elasticsearch/elasticsearch:8.10.2
```

#### 3.2 Run Elasticsearch in Docker

Once the image is pulled, you can start Elasticsearch in a Docker container by running the following command:

``` bash
sudo docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 \
  -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  docker.elastic.co/elasticsearch/elasticsearch:8.10.2
```

This command will:

- Run Elasticsearch in single-node mode.  
- Disable security features (for simplicity in development). You can enable security later if needed.  
- Expose Elasticsearch on ports 9200 (for HTTP) and 9300 (for internal communication).

#### 3.3 Verify Elasticsearch is Running

After the container starts, verify that Elasticsearch is up and running by checking its status with the following curl command:

``` bash
curl http://localhost:9200
```

You should receive a JSON response with Elasticsearch cluster information, confirming that it is working properly.

### 4. Configure Application to Use Elasticsearch

The application is configured to use Elasticsearch via the MyClientConfig.java class. You don't need to manually configure Elasticsearch if you've followed the previous steps to run it in Docker. The application will connect to the running Docker container on port 9200.  

#### 4.1 Change CSV File Path (if needed)

The application can read data from a CSV file and index it in Elasticsearch. You can modify the path to the CSV file in the application.properties file, like this:

``` properties
csv.file.path=/path/to/your/csv/file.csv
```

Ensure that the CSV file follows the expected format for your entity (e.g., Person).

### 5. Test the REST Endpoints

Once the application is running and Elasticsearch is configured, you can test the REST API endpoints to ensure everything is working.

#### 5.1 Start the Spring Boot Application
You can run the Spring Boot application using the following Maven command:

``` bash
mvn spring-boot:run
```
Or if you're using an IDE like IntelliJ IDEA , Eclipse or VS Code , you can run the application directly from there.

#### 5.2 Test with Postman

After the application starts, use Postman (or any other API testing tool) to test the REST endpoints. 
```
See Person Service Class for usage of endpoints.
```


## Troubleshooting

If you encounter any issues during setup, please check the following:

- Docker Container: Ensure the Elasticsearch Docker container is running correctly by using sudo docker ps.
- Elasticsearch Logs: Check the Elasticsearch logs using sudo docker logs <container_name> for any errors.
- Spring Boot Logs: If the application isn't running as expected, check the Spring Boot application logs for any errors related to the Elasticsearch connection.


## Conclusion

By following the above steps, you should be able to integrate Elasticsearch with Spring Boot and test it using Docker. This setup provides a flexible, easy-to-use environment for developing Elasticsearch-based applications with Spring Boot.

For further reference, you can consult the official Elasticsearch and Spring Boot documentation:

- Elasticsearch Documentation
- Spring Data Elasticsearch Documentation

Feel free to contribute to this project or open an issue if you encounter any problems.


### Key Points in the `README.md`:
1. **Step-by-step instructions**: Detailed setup for Docker, Elasticsearch, and Spring Boot.
2. **Commands for Docker**: Clear steps for running Elasticsearch via Docker.
3. **Configuration for the CSV file**: How to modify the CSV path in `application.properties`.
4. **Testing Endpoints**: Instructions on how to test the endpoints with Postman.
5. **Troubleshooting**: Common issues with Docker and Spring Boot are addressed.

You can now copy and paste this into your `README.md` file. Let me know if you need further modifications!