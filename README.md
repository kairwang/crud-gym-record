# Gym Personal Records CRUD Application

This project is a simple CRUD (Create, Read, Update, Delete) application for managing gym personal records.

## Technologies Used

- **Backend**: Built with Spring Boot, using Java, JPA (Java Persistence API), PostgreSQL for the database, Mapstruct for mapping entities, and Lombok for reducing boilerplate code.
  
- **Frontend**: Developed with React, utilizing TypeScript for type-safe programming and CSS for styling.

## Features

- **CRUD Operations**: Allows users to Create, Read, Update, and Delete gym personal records.
  
- **Integration**: Seamlessly integrates between the Spring Boot backend and React frontend.

## Getting Started

To get started with this project, follow these steps:

1. **Clone the repository**:
   In terminal run the following.
   ```bash
   git clone https://github.com/yourusername/gym-personal-records.git
   cd gym-personal-records
   ```
   
2. **Backend Setup**:
   Navigate to the backend directory.
   Configure your PostgreSQL database settings in application.properties.
   Run the Spring Boot application:
   ```bash
   /mvnw spring-boot:run
   ```
   
3. **Frontend Setup**:
   Navigate to the frontend directory.
   Install dependencies:
   ```bash
   npm install
   ```
   Start the React development server:
   ```bash
   npm start
   ```
   
4. **Verifying your Application**:
   - **Backend**: Make sure your Spring Boot backend is running and listening for requests at the configured port (default is 8080).
   - **Frontend**: Open your browser and navigate to http://localhost:4200 (or the port your React app is running on). Verify that the frontend is correctly interacting with the backend.



