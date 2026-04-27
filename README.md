# Hospital Management System (Java OOP) 🏥

A console-based Medical Consultation Management System developed entirely in **Java**. This project demonstrates the practical application of **Object-Oriented Programming (OOP)** principles to solve real-world administrative challenges in the healthcare sector.

##  Overview
This system allows clinic administrators to efficiently manage medical staff, patient records, and schedule consultations. It features a persistent data storage mechanism, ensuring that all records are safely saved and loaded across different sessions.

##  OOP Concepts Applied
This project was designed with a strong focus on software architecture and clean code:
* **Inheritance & Polymorphism:** Implementation of a base superclass (`Persona`) extended by specialized subclasses (`Doctor` and `Paciente`) to reuse code and maintain a logical hierarchy.
* **Encapsulation:** Strict use of private attributes with getters and setters to protect data integrity.
* **Data Persistence (Serialization):** Utilization of `ObjectInputStream` and `ObjectOutputStream` to save system states into `.dat` files (`pacientes.dat`, `doctores.dat`, `consultas.dat`).
* **Collection Framework:** Heavy use of `ArrayList` for dynamic data management and efficient searching algorithms (e.g., finding patients by ID or consultations by date).

## 📁 System Entities
* `Persona.java`: Base class handling common attributes (ID, Name, Age).
* `Paciente.java` / `Doctor.java`: Inherited classes adding specific attributes like medical specialty or gender.
* `Consulta.java`: Entity linking a Doctor, a Patient, a date, and a medical diagnosis.
* `GestorDatos.java`: The core engine for File I/O operations and data serialization.
* `Main.java`: The interactive console-based user interface.

##  Academic Context
Developed as part of the **Object-Oriented Programming** coursework at the **Instituto Tecnológico de La Paz**. This project aligns with my interest in creating robust software solutions for Healthcare and Biomedicine.
