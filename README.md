# Netty WebSocket Server with Spring Boot and Python Clients

This project demonstrates a WebSocket server implemented using Netty in a Spring Boot application. The server is capable of receiving WebSocket messages from clients and setting up instant communication.



## Tech Stack
This project demonstrates a WebSocket server implemented using Netty.io with a Spring Boot application and a Python client. The server echoes messages received from clients. The tech stack includes:
```bash

Server-Side (Java 20, Netty.io, Spring Boot)

 1. Java 20
 Java is a versatile, object-oriented programming language known for its platform independence and robustness.
 Used for the server-side implementation to handle WebSocket connections and communication.

 2. Netty.io
 Netty is a NIO (Non-blocking I/O) client-server framework for Java, designed for building scalable network applications.
 Utilized for implementing the WebSocket server, providing efficient tools for network application development.

 3. Spring Boot 3.1.5
 Spring Boot is a framework that simplifies the development of production-ready applications in the Spring ecosystem.
 Integrated with Netty.io to enhance the WebSocket server capabilities.

 Client-Side (Python 3.11.6)

 4. Python 3.11.6
 Python is a high-level, interpreted programming language known for its readability and versatility.
 Used for implementing a simple WebSocket client that connects to the server and sends/receives messages.

```

## Project Structure:
```bash
nettyServer
|-- README.md
|-- pom.xml
|-- src
|   |-- main
|       |-- java
|       |   |-- com.nettyServer
|       |       |-- WebSocketServer.java
|       |       |-- WebSocketServerHandler.java
|       |       |-- WebSocketServerInitializer.java
|       |-- python
|           |-- main.py
```



## How to Run the Server:
1. Clone the repository: `git clone https://github.com/Narennnnn/nettySpringServerPythonClients`
2. Open the project in your favorite IDE or build using Maven.
3. Run the `WebSocketServer` class.

## How to Run the Python Client:
1. Ensure you have Python installed on your machine.
2. Navigate to the `python` directory in the project
3. Install required libraries: `pip install -r requirements.txt `
4. Run the Python script: `python main.py`

## Server Configuration:
- The server is configured to run on `localhost:8080`.
- WebSocket endpoint is `/websocket`.

## WebSocket Communication:
- The server echoes back messages received from clients.
- The Python client sends messages to the server and displays the echoed responses.


## Future IoT Integration with Netty WebSocket Server and Spring Boot


### 1. Home Automation
   - **Description:** Control and monitor smart home devices, such as lights, thermostats, and door locks.
   - **Implementation:** Create WebSocket handlers to interpret messages related to home appliance control and sensor data from smart devices.

### 2. Environmental Monitoring
   - **Description:** Monitor environmental conditions using IoT sensors, such as temperature, humidity, and air quality.
   - **Implementation:** Develop handlers to process sensor data sent by environmental monitoring devices and provide real-time updates.

### 3. Industrial IoT (IIoT)
   - **Description:** Connect and manage IoT devices in an industrial setting, including machinery, sensors, and actuators.
   - **Implementation:** Design specific handlers to handle commands and data from industrial devices, ensuring reliable and secure communication.

### 4. Health Monitoring
   - **Description:** Collect health data from wearable devices or medical sensors for remote patient monitoring.
   - **Implementation:** Extend the server to process health-related data and implement alerts or notifications based on specific thresholds.


Feel free to explore and modify the code to suit your requirements.

**Note:** Ensure that dependencies specified in the `pom.xml` file are installed or are available in your project environment.

For any issues or questions, please contact [mauryanarendra2003@gmail.com].

Happy coding!
