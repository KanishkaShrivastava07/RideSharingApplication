# Ride-Sharing Dispatch System  

---
## Project Overview

The **Ride-Sharing Dispatch System** is a real-life Java multithreading project that simulates the **core backend logic of ride-sharing platforms**.

The system handles **multiple passenger ride requests concurrently** while safely managing a **limited pool of drivers**. It ensures that:
- A driver is never assigned to more than one passenger
- Passengers wait if drivers are unavailable
- Drivers are reused efficiently after ride completion

This project focuses on **thread safety, synchronization, and inter-thread communication**.

---

## Objectives

- Simulate real-world concurrent ride requests
- Implement thread-safe driver allocation
- Prevent race conditions
- Demonstrate `wait()` and `notify()` usage
- Model real backend resource pooling behavior

---

## Concepts Used

- Java Threads
- `Runnable` Interface
- `synchronized` Methods
- Shared Resources
- `wait()` and `notify()`
- Thread Lifecycle
- Producer–Consumer Pattern
- Object-Oriented Programming (OOP)

---

## System Workflow

1. The system starts with a limited number of drivers.
2. Multiple passengers request rides simultaneously.
3. Each passenger request runs as a separate thread.
4. If a driver is available, it is assigned immediately.
5. If no driver is available, the passenger thread waits.
6. Once a ride completes, the driver is released.
7. A waiting passenger is notified and assigned the driver.

This cycle continues continuously, similar to real ride-sharing systems.

---

## Process Flow Diagram

<img width="992" height="734" alt="image" src="https://github.com/user-attachments/assets/8775f92a-d95d-4f11-b1d4-e2e843785094" />


### Diagram Explanation
- A passenger request starts a new thread.
- The request enters the `DriverPool`, which is a shared resource.
- The system checks driver availability.
- If a driver is available, it is assigned immediately.
- If not, the passenger thread enters the waiting state using `wait()`.
- When a ride completes, the driver is released and `notify()` is called.
- A waiting passenger wakes up and gets assigned a driver.

---

## Sample Output

- Ride Sharing System Started

- Driver 1 assigned to Passenger-1
- Driver 2 assigned to Passenger-2
- Driver 3 assigned to Passenger-3

- Passenger-4 is waiting for a driver...
- Passenger-5 is waiting for a driver...

- Driver 1 is now available
- Driver 1 assigned to Passenger-4

> Output order may vary due to concurrent thread execution. This is expected behavior.

---

## Thread Safety Explanation

- `DriverPool` is a shared resource.
- Access to it is controlled using `synchronized` methods.
- `wait()` pauses passenger threads when drivers are unavailable.
- `notify()` wakes up waiting threads when a driver is released.
- This ensures **no double booking** and **safe concurrency**.

---
## How to Run the Project

### Prerequisites

Make sure the following are installed on your system:

- **Java JDK 8 or above**
- Any Java IDE (IntelliJ IDEA / Eclipse / VS Code)  
  **OR**
- Command Line (Terminal / Command Prompt)

---

### Option 1: Run Using an IDE (Recommended)

1. Open your IDE (IntelliJ / Eclipse / VS Code).
2. Import or open the `RideSharingSystem` project folder.
3. Ensure all `.java` files are in the same package (or default package).
4. Locate the file:
RideSharingApplication.java

yaml
Copy code
5. Right-click on the file → **Run**.
6. Observe the output in the console.

---

### Option 2: Run Using Command Line

1. Open **Terminal / Command Prompt**.
2. Navigate to the project directory:
```bash
cd RideSharingSystem
Compile all Java files:

bash
Copy code
javac *.java
Run the main application:

bash
Copy code
java RideSharingApplication
The console will display concurrent passenger and driver activity.
```

---
## Future Enhancements

- There will be more enchancements in the future.
  
---

