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

BusTicketBooking/
│── src/
│ ├── Bus.java
│ ├── Passenger.java
│ ├── BookingSystem.java
│ └── Main.java
│── db/
│ └── schema.sql
│── README.md

---

## ⚡ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/mohanarajshankar/bus-ticket-booking.git
   cd bus-ticket-booking

2. Set up Oracle Database:

Create schema using db/schema.sql

Update DB connection in BookingSystem.java

3. Compile and run:

javac src/*.java
java src/Main

