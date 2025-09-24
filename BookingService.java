package org.busTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookingService {

    static Scanner sc = new Scanner(System.in);

    // View all buses
    public static void viewBuses() throws Exception {
        Connection con = DBconnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM BUSES");
        while (rs.next()) {
            System.out.println("Bus ID: " + rs.getInt(1) +
                    " | Name: " + rs.getString(2) +
                    " | " + rs.getString("SOURCE") +
                    " -> " + rs.getString("DESTINATION") +
                    " | Seats: " + rs.getInt("SEATS"));
        }

        rs.close();
        st.close();
        con.close();
    }

    // Book a ticket
    public static void bookTicket(int loggedInUserId) throws Exception {
        Connection con = DBconnection.getConnection();

        System.out.print("Enter Bus ID: ");
        int busId = sc.nextInt();
        System.out.print("Enter No. of Seats: ");
        int seats = sc.nextInt();

        // check available seats
        String checkSeats = "SELECT seats FROM buses WHERE busid=?";
        PreparedStatement pst = con.prepareStatement(checkSeats);
        pst.setInt(1, busId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int available = rs.getInt("seats");
            if (available < seats) {
                System.out.println("❌ Not enough seats available!");
                
            }
            
        }

        // insert booking
        String sql = "INSERT INTO busbookingrecords(seatsbooked, userid, busid) VALUES(?,?,?)";
        pst = con.prepareStatement(sql);
        pst.setInt(1, seats);
        pst.setInt(2, loggedInUserId);
        pst.setInt(3, busId);
        pst.executeUpdate();

        // reduce seat count in buses
        String updateSeats = "UPDATE buses SET seats = seats - ? WHERE busid=?";
        pst = con.prepareStatement(updateSeats);
        pst.setInt(1, seats);
        pst.setInt(2, busId);
        pst.executeUpdate();
        
//        String busid = "SELECT busid FROM busbookingrecords WHERE userid=  loggedInUserId";
//        PreparedStatement pst1 = con.prepareStatement(busid);
//        pst1.setInt(1, busId);
//        ResultSet rs1 = pst.executeQuery();
        
        System.out.println("✅ Booking successful! ");

        rs.close();
        pst.close();
        con.close();
    }

    // Cancel a ticket
    public static void cancelTicket(int loggedInUserId) throws Exception {
        Connection con = DBconnection.getConnection();

        System.out.print("Enter Booking ID to cancel: ");
        int id = sc.nextInt();

        // find seats booked for this record
        String find = "SELECT seatsbooked, busid FROM busbookingrecords WHERE bookingid=? AND userid=?";
        PreparedStatement pst = con.prepareStatement(find);
        pst.setInt(1, id);
        pst.setInt(2, loggedInUserId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int seats = rs.getInt("seatsbooked");
            int busId = rs.getInt("busid");

            // delete booking
            String sql = "DELETE FROM busbookingrecords WHERE bookingid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

            // add seats back to bus
            String updateSeats = "UPDATE buses SET seats = seats + ? WHERE busid=?";
            pst = con.prepareStatement(updateSeats);
            pst.setInt(1, seats);
            pst.setInt(2, busId);
            pst.executeUpdate();

            System.out.println("✅ Booking cancelled & seats restored!");
        } else {
            System.out.println("❌ Booking not found or not yours!");
        }

        rs.close();
        pst.close();
        con.close();
    }
}
