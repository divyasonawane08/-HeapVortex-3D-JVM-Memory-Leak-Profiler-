# Heap Vortex 3D JVM Memory Leak Profiler

## Overview

**Heap Vortex** is a 3D JVM memory leak profiling and visualization platform designed to monitor Java applications, analyze heap usage, and visualize memory relationships in an interactive 3D environment.

The project combines **Java monitoring, heap dump analysis, Spring Boot backend services, and React + Three.js visualization** to help developers understand JVM memory behavior and identify potential memory leaks.

## Features

* 🚀 Real-time JVM memory monitoring
* 📊 Heap usage and JVM metrics visualization
* 🔍 Heap dump generation and analysis
* 🧠 Memory leak detection support
* 🌐 REST API based backend architecture
* 🎮 Interactive 3D memory visualization using Three.js
* 📈 Live telemetry updates using WebSocket communication
* 🗂️ Eclipse MAT based heap analysis integration

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Web
* REST APIs
* JMX Monitoring
* Eclipse MAT APIs
* Maven

### Frontend

* React.js
* Vite
* Three.js
* Axios
* WebSocket / STOMP

### Tools

* Git & GitHub
* Docker
* Eclipse Memory Analyzer (MAT)
* VisualVM
* JConsole

## Architecture

```
                 Java Application
                        |
                        |
                    JMX Agent
                        |
                        |
              Spring Boot Backend
                        |
        --------------------------------
        |                              |
 JVM Metrics API              Heap Dump Analyzer
        |
        |
    WebSocket
        |
        |
 React + Three.js 3D Visualization
```

## Project Structure

```
Heap Vortex
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── Heap Analysis Services
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── 3D Visualization UI
│
├── mat/
│   └── Eclipse MAT Resources
│
├── docker-compose.yml
└── README.md
```

## How It Works

1. The JVM exposes runtime information through **JMX**.
2. The backend connects with the JVM and collects:

   * Heap memory usage
   * Thread count
   * Loaded classes
   * CPU usage
3. Heap dumps are generated for deeper memory analysis.
4. Eclipse MAT APIs analyze heap dump data.
5. The frontend displays JVM objects and memory relationships in a 3D environment.

## Running the Project

### Backend

Navigate to backend:

```bash
cd backend
```

Run:

```bash
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

### Frontend

Navigate to frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Run:

```bash
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

## Heap Dump Generation

Generate a heap dump from a running JVM:

```bash
jcmd <PID> GC.heap_dump heapdump.hprof
```

The generated `.hprof` file can be analyzed using Eclipse MAT.

## Future Enhancements

* AI-based memory leak prediction
* Cloud JVM monitoring
* Multi-application monitoring dashboard
* Advanced object reference graph analysis
* Production deployment support

* <img width="517" height="645" alt="HeapVortexOutput" src="https://github.com/user-attachments/assets/40aa45f1-405f-48d0-98e7-399273129ba0" />


## Author

**Divya Sonawane**

## License

This project is developed for learning, research, and JVM performance monitoring purposes.
