# 🚌 Bus Ticket Booking System

A Java-based bus ticket booking application integrated with Oracle Database.  
It allows users to search buses, check availability, book/cancel tickets, and manage passenger details efficiently.  

## 🚀 Features
- 🔍 Search buses by route, date, and time  
- 🪑 Real-time seat availability tracking  
- 🎟️ Book, cancel, and view tickets  
- 👤 Passenger details management  
- 🛡️ Secure database integration with Oracle  

## 📂 Project Structure

│── src/
│ ├── controller/
│ │ └── BusController.java # Handles bus-related operations
│ ├── service/
│ │ ├── BookingService.java # Booking logic & validations
│ │ └── UserService.java # Passenger management
│ ├── db/
│ │ └── DBConnection.java # Oracle DB connection setup
│ ├── model/
│ │ ├── Bus.java # Bus entity
│ │ └── Passenger.java # Passenger entity
│ └── Main.java # Entry point of the application
│
│── db/
│ └── schema.sql # Oracle DB schema & tables
│── README.md


---

## ⚡ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/mohanarajshankar/bus-ticket-booking.git
   cd bus-ticket-booking

2. Set up Oracle Database:

Run the db/schema.sql file to create required tables.

Update database URL, username, and password in DBConnection.java.

3. Compile and Run the program:

javac src/**/*.java
java src/Main

