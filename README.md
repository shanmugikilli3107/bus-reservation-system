# Bus Reservation System
A backend application built using Java and Spring Boot that allows users to manage buses and make reservations.

This project focuses on building a real-world bus booking system with features like bus management, seat reservation, booking management, and exception handling.

The project is currently under development, and additional features like authentication, payment integration, and deployment will be added in future updates.
## Project Overview
The Bus Reservation System helps manage the complete bus booking process.

The system allows:

- Admins to manage bus details
- Users to view available buses
- Passengers to reserve seats
- The application to track bookings
- Prevention of duplicate seat reservations
## Technologies Used

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs

### Database
- MySQL

### Build Tool
- Maven

### Testing Tools
- Postman
- Swagger (Coming Soon)
## 🏗️ Project Architecture

This project follows a layered architecture:

Controller Layer
↓
Service Layer
↓
Repository Layer
↓
Database


### Controller Layer
Handles HTTP requests and responses.


### Service Layer
Contains business logic like validation and processing.


### Repository Layer
Handles communication with the database using JPA.


### Model Layer
Contains database entity classes like Bus and Booking.


### Exception Handling Layer
Handles application errors and provides meaningful responses.
##  Current Features

### Bus Management

✅ Add bus

✅ View all buses

✅ Search bus by ID

✅ Update bus details

✅ Delete bus


### Booking Management

✅ Create booking

✅ View bookings

✅ Update booking

✅ Delete booking

✅ Prevent duplicate seat booking


### Exception Handling

Implemented custom exceptions:

- BusNotFoundException
- BookingNotFoundException
- SeatAlreadyExistsException
- InvalidDeleteCriteriaException

# 🔗 API Endpoints

The Bus Reservation System provides REST APIs for managing buses and passenger bookings.

Base URL:


http://localhost:8082/api/v1


---

# 🚌 Bus Management APIs

## 1. Create Bus

Creates a new bus in the system.

**HTTP Method:**

POST


**Endpoint:**

/bus/CreateBus


**Full URL:**

POST http://localhost:8082/api/v1/bus/CreateBus


---

## 2. Get All Buses

Retrieves all available buses.

**HTTP Method:**

GET


**Endpoint:**

/bus/allBuses


**Full URL:**

GET http://localhost:8082/api/v1/bus/allBuses


---

## 3. Get Bus By ID

Retrieves a specific bus using its ID.

**HTTP Method:**

GET


**Endpoint:**

/bus/{id}


**Example:**

GET http://localhost:8082/api/v1/bus/1


---

## 4. Get Bus By Bus Number

Searches a bus using the bus number.

**HTTP Method:**

GET


**Endpoint:**

/bus/busNo?busNo={busNo}


**Example:**

GET http://localhost:8082/api/v1/bus/busNo?busNo=101


---

## 5. Get Bus By AC Type

Retrieves buses based on AC availability.

**HTTP Method:**

GET


**Endpoint:**

/bus/acBus?acBus={value}


**Example:**

GET http://localhost:8082/api/v1/bus/acBus?acBus=YES


---

## 6. Update Bus

Updates existing bus details.

**HTTP Method:**

PUT


**Endpoint:**

/bus/updateBus/{id}


**Example:**

PUT http://localhost:8082/api/v1/bus/updateBus/1


---

## 7. Delete Bus

Deletes a bus using its ID.

**HTTP Method:**

DELETE


**Endpoint:**

/bus/{id}


**Example:**

DELETE http://localhost:8082/api/v1/bus/1


---

# 🎟️ Booking Management APIs

## 1. Create Booking

Creates a new booking for a passenger.

**HTTP Method:**

POST


**Endpoint:**

/bookings/createBooking


**Full URL:**

POST http://localhost:8082/api/v1/bookings/createBooking


---

## 2. Get Booking By ID

Retrieves booking details using booking ID.

**HTTP Method:**

GET


**Endpoint:**

/bookings/getBookingById/{id}


**Example:**

GET http://localhost:8082/api/v1/bookings/getBookingById/1


---

## 3. Get Booking By Seat Number

Retrieves booking details using bus ID and seat number.

**HTTP Method:**

GET


**Endpoint:**

/bookings/getBookingBySeatNumber/{busId}/{seatNumber}


**Example:**

GET http://localhost:8082/api/v1/bookings/getBookingBySeatNumber/1/A1


---

## 4. Get Booking By Passenger Name

Retrieves all bookings made by a passenger.

**HTTP Method:**

GET


**Endpoint:**

/bookings/getBookingByPassengerName/{passengerName}


**Example:**

GET http://localhost:8082/api/v1/bookings/getBookingByPassengerName/John


---

## 5. Get All Bookings

Retrieves all bookings in the system.

**HTTP Method:**

GET


**Endpoint:**

/bookings/getAllBookings


**Full URL:**

GET http://localhost:8082/api/v1/bookings/getAllBookings


---

## 6. Get All Bookings By Bus ID

Retrieves all bookings associated with a particular bus.

**HTTP Method:**

GET


**Endpoint:**

/bookings/getAllBookingsByBusId/{id}


**Example:**

GET http://localhost:8082/api/v1/bookings/getAllBookingsByBusId/1


---

## 7. Update Booking

Updates booking information.

**HTTP Method:**

PUT


**Endpoint:**

/bookings/updateSeatNumber/{id}


**Example:**

PUT http://localhost:8082/api/v1/bookings/updateSeatNumber/1


---

## 8. Delete Booking

Deletes booking using ID, seat number, or bus ID.

**HTTP Method:**

DELETE


**Endpoint:**

/bookings/deleteBooking


**Delete By Booking ID Example:**

DELETE http://localhost:8082/api/v1/bookings/deleteBooking?id=1


**Delete By Seat Number and Bus ID Example:**

DELETE http://localhost:8082/api/v1/bookings/deleteBooking?seatNumber=A1&busId=1

##  Future Enhancements

### User Management

- User registration
- Login
- JWT Authentication
- Role-based access


### Booking Features

- Booking cancellation
- Booking history
- Ticket generation
- Email confirmation


### Payment

- Online payment integration
- Payment status tracking
- Payment history


### Advanced Features

- Docker
- CI/CD Pipeline
- Cloud Deployment
- Automated Testing

## 📚 What I Learned

Through this project, I am practicing:

- Building REST APIs using Spring Boot
- Designing backend applications
- Working with MySQL and JPA
- Entity relationships
- Exception handling
- CRUD operations
- API testing using Postman
- Writing clean backend code

##  Author

Manishanmugi Killivalavan

GitHub:
https://github.com/shanmugikilli3107