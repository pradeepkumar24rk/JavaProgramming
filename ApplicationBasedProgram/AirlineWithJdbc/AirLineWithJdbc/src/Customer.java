import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Customer extends AMS {

    public static void editCustomerProfile() {
        

        System.out.print("Enter the new user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter the new password: ");
        String password = sc.nextLine();

        System.out.print("Enter the new phone: ");
        Long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the new email: ");
        String email = sc.nextLine();

        System.out.print("Enter the new address1: ");
        String address1 = sc.nextLine();

        System.out.print("Enter the new address2: ");
        String address2 = sc.nextLine();

        System.out.print("Enter the new city: ");
        String city = sc.nextLine();

        System.out.print("Enter the new state: ");
        String state = sc.nextLine();
        
        System.out.print("Enter the new state: ");
        String country = sc.nextLine();

        System.out.print("Enter the new zipcode: ");
        Long zipcode = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the new dob [dd-MM-yyyy]: ");
        String dobStr = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(dobStr, formatter);

        int userId = loggedInUser.getUserId();
        
        String sql = "SELECT * FROM User WHERE userId = ? ";
        String UpdateCustomerSql = "UPDATE User SET userName=?, password=?, phone=?, emailId=?, address1=?, address2=?, city=?, state=?, country=?, zipCode=?, dob=? WHERE userId=?";
        try (Connection conn = DBConnection.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        		) {
    		ps.setInt(1,userId);
    		
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			PreparedStatement ps2 = conn.prepareStatement(UpdateCustomerSql);
    			ps2.setString(1, userName);
        	    ps2.setString(2, password);
        	    ps2.setLong(3, phone);
        	    ps2.setString(4, email);
        	    ps2.setString(5, address1);
        	    ps2.setString(6, address2);
        	    ps2.setString(7,city);
        	    ps2.setString(8, state);
        	    ps2.setString(9, country);
        	    ps2.setLong(10, zipcode);
        	    ps2.setDate(11, Date.valueOf(dob)); 
        	    ps2.setInt(12,userId);
    			ps2.executeUpdate();
    			System.out.println("Your Profile Edited Successfully!");
    			
    		} else {
    			
    			System.out.println("Error: Invalid customer ID.");
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bookTicket() {
    // System.out.println(flightBookingCount);
       
        System.out.print("Enter Flight Schedule Id: ");
        int flightScheduleId = sc.nextInt();
    
        System.out.print("Enter No of Seats: ");
        int noOfSeats = sc.nextInt();
        sc.nextLine();
    
        System.out.print("Enter Seat Class: ");
        String seatCategory = sc.nextLine();
        
        fetchData();
    
        FlightSchedule bookingFlight = flightScheduleList.get(flightScheduleId - 1);
        Flight flightDetails = flightList.get(bookingFlight.getFlightId() - 1);
        Carrier carrierDetails = carrierList.get(flightDetails.getCarrierId() - 1);
    
        int remainingEconomySeats = flightDetails.getEconomyClassSeatCapacity() - bookingFlight.getEconomyClassBookedCount();
        int remainingBusinessSeats = flightDetails.getBusinessClassSeatCapacity() - bookingFlight.getBussinessClassBookingCount();
        int remainingExecutiveSeats = flightDetails.getExecutiveClassSeatCapacity() - bookingFlight.getExecutiveClassBookedCount();
    
        // System.out.println(remainingBusinessSeats);
    
        int bookingAmount = 0;
        if (seatCategory.equalsIgnoreCase("Economy")) {
            if (remainingEconomySeats < noOfSeats) {
                System.out.println("Not enough seats available. Remaining: " + remainingEconomySeats);
                return;
            }
            bookingAmount = flightDetails.getAirFare();
            bookingFlight.setEconomyClassBookedCount(bookingFlight.getEconomyClassBookedCount() + noOfSeats);
        } else if (seatCategory.equalsIgnoreCase("Business")) {
            if (remainingBusinessSeats < noOfSeats) {
                System.out.println("Not enough seats available. Remaining: " + remainingBusinessSeats);
                return;
            }
            bookingAmount = flightDetails.getAirFare() * 2;
            bookingFlight.setBussinessClassBookingCount(bookingFlight.getBussinessClassBookingCount() + noOfSeats);
        } else if (seatCategory.equalsIgnoreCase("Executive")) {
            if (remainingExecutiveSeats < noOfSeats) {
                System.out.println("Not enough seats available. Remaining: " + remainingExecutiveSeats);
                return;
            }
            bookingAmount = flightDetails.getAirFare() * 5;
            bookingFlight.setExecutiveClassBookedCount(bookingFlight.getExecutiveClassBookedCount() + noOfSeats);
        } else {
            System.out.println("Invalid seat category.");
            return;
        }
        // System.out.println(bookingAmount);
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfTravel = LocalDate.parse(bookingFlight.getDateOfTravel(), formatter);
    
        
        if (loggedInUser.getCategory().equalsIgnoreCase("Silver")) {
            bookingAmount -= (bookingAmount * carrierDetails.getSilverUserDiscount()) / 100;
            
        } else if (loggedInUser.getCategory().equalsIgnoreCase("Gold")) {
            bookingAmount -= (bookingAmount * carrierDetails.getGoldUserDiscount()) / 100;
            
        } else if (loggedInUser.getCategory().equalsIgnoreCase("Platinum")) {
            bookingAmount -= (bookingAmount * carrierDetails.getPlatinumUserDiscount()) / 100;
            
        }
        // System.out.println(bookingAmount);
    
        long daysBetween = ChronoUnit.DAYS.between(currentDate, dateOfTravel);
        
       
        if (daysBetween > 90) {
            bookingAmount -= (bookingAmount * carrierDetails.getDiscountPercentageNinetyDaysAdvanceBooking()) / 100;
        } else if (daysBetween > 60) {
            bookingAmount -= (bookingAmount * carrierDetails.getDiscountPercentageSixtyDaysAdvanceBooking()) / 100;
        } else if (daysBetween > 30) {
            bookingAmount -= (bookingAmount * carrierDetails.getDiscountPercentageThirtyDaysAdvanceBooking()) / 100;
        }
        // System.out.println(bookingAmount);
    
        
        if (noOfSeats >= 10) {
            bookingAmount -= (bookingAmount * carrierDetails.getBulkBookingDiscount()) / 100;
        }
        // System.out.println(bookingAmount);
        
        try (Connection conn = DBConnection.getConnection();) {
    	    
    	    String sql = "INSERT INTO FlightBooking ( flightId, userId, noOfSeats, seatCategory, dateOfTravel, bookingStatus, bookingAmount) " +
    	                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
    	    
    	    PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    	   
    	    ps.setInt(1,  bookingFlight.getFlightId());
    	    ps.setInt(2, loggedInUser.getUserId());
    	    ps.setInt(3, noOfSeats);
    	    ps.setString(4, seatCategory);
    	    ps.setDate(5, Date.valueOf(dateOfTravel));
    	    ps.setString(6, "Booked");
    	    ps.setInt(7, bookingAmount);
    	    
    	    ps.executeUpdate();
    	    ResultSet rs = ps.getGeneratedKeys();
    	    if(rs.next()) {
    	    	int generatedId = rs.getInt(1);
    	    	System.out.println("Flight Booked Successfully.Booking ID: " + generatedId +". Ticket Price Rs. "+bookingAmount);
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}

    
       
    }
    
    public static void cancelTicket() {
        System.out.print("Enter Booking Id: ");
        int bookingId = sc.nextInt();
        
        fetchData();
        
        FlightBooking fb = flightBookingList.get(bookingId-1);
        FlightSchedule fs = null;
        Flight f = flightList.get(fb.getFlightId()-1);
        Carrier c = carrierList.get(f.getCarrierId()-1);
        
        for(int i=0;i<flightScheduleList.size();i++) {
            FlightSchedule temp = flightScheduleList.get(i);
            if(temp.getFlightId()==fb.getFlightId() && temp.getDateOfTravel().equals(temp.getDateOfTravel()))
                fs = temp;
        }
        
        if(fs == null){
            System.out.println("Not able to find the schedule flight");
            return;
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfTravel = LocalDate.parse(fb.getDateOfTravel(), formatter);
        
        long daysBetween = ChronoUnit.DAYS.between(currentDate, dateOfTravel);
        
        if (fb.getSeatCategory().equalsIgnoreCase("Economy")) {
            fs.setEconomyClassBookedCount(fs.getEconomyClassBookedCount() - fb.getNoOfSeats());
        } else if (fb.getSeatCategory().equalsIgnoreCase("Business")) {
            fs.setBussinessClassBookingCount(fs.getBussinessClassBookingCount() - fb.getNoOfSeats());
        } else if (fb.getSeatCategory().equalsIgnoreCase("Executive")) {
            fs.setExecutiveClassBookedCount(fs.getExecutiveClassBookedCount() - fb.getNoOfSeats());
        } else {
            System.out.println("Invalid seat category.");
            return;
        }
        
        String sql = "SELECT * FROM FlightBooking WHERE bookingId=? ";
        try (Connection conn = DBConnection.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        		) {
    		ps.setInt(1,bookingId);

    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			String insertScheduleFlightSql = "UPDATE FlightBooking SET bookingStatus=? WHERE bookingId=?)";
    			PreparedStatement ps2 = conn.prepareStatement(insertScheduleFlightSql,Statement.RETURN_GENERATED_KEYS);
    			ps2.setString(1, "Cancelled");
    			ps2.setInt(2, bookingId);
    			ps2.executeUpdate();
    		}
    		else {
    			System.out.println("Not able to find the Booked flight");
    			return;
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        if(daysBetween == 20)
            System.out.println("Your Ticket have cancelled Successfully. Your Refund Amount Rs. "+(fb.getBookingAmount()*c.getRefundPercentageForTicketCancelling20DayBeforeTravelDate())/100); 
        else if(daysBetween == 10) 
            System.out.println("Your Ticket have cancelled Successfully. Your Refund Amount Rs. "+(fb.getBookingAmount()*c.getRefundPercentageForTicketCancelling10DayBeforeTravelDate())/100); 
        else if(daysBetween == 2)
            System.out.println("Your Ticket have cancelled Successfully. Your Refund Amount Rs. "+(fb.getBookingAmount()*c.getRefundPercentageForTicketCancelling2DayBeforeTravelDate())/100); 
        else 
            System.out.println("Your Ticket have cancelled Successfully. Your Refund Amount Rs. 0"); 
        
    }

    public static boolean customerMenu() {
        int choose_menu;
        do {
            System.out.println("\nWelcome Back");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Customer Menu\n1.Edit Customer Profile\n2.Ticket Booking\n3.Ticket Cancelling\n4.Exit Customer\n5.Exit AMS");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Enter the operation: ");
            choose_menu = sc.nextInt();
            sc.nextLine();
            switch (choose_menu) {
                case 1:
                    System.out.println("Edit Customer Profile");
                    editCustomerProfile();
                    break;
                case 2:
                    System.out.println("Ticket Booking");
                    bookTicket();
                    break;
                case 3:
                    System.out.println("Ticket Cancelling");
                    cancelTicket();
                    break;
                case 4:
                  System.out.println("Exit Customer");
                  break;
                case 5:
                    System.out.println("Exit AMS");
                    return true;
                default:
                    System.out.println("Invalid");
            }
        } while (choose_menu != 4);
        return false;
    }

}
