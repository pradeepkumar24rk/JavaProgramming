import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Admin extends AMS {

  public static void createCarrier() {
   
    System.out.print("Enter the Carrier Name: ");
    String carrierName = sc.nextLine().trim();

    System.out.print("Enter Discount for 30 Days Advance Booking: ");
    int discount30Days = sc.nextInt();

    System.out.print("Enter Discount for 60 Days Advance Booking: ");
    int discount60Days = sc.nextInt();

    System.out.print("Enter Discount for 90 Days Advance Booking: ");
    int discount90Days = sc.nextInt();

    System.out.print("Enter Bulk Booking Discount: ");
    int bulkBooking = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (2 Days Before): ");
    int refund2Days = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (10 Days Before): ");
    int refund10Days = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (20 Days Before): ");
    int refund20Days = sc.nextInt();

    System.out.print("Enter Silver User Discount: ");
    int silverDiscount = sc.nextInt();

    System.out.print("Enter Gold User Discount: ");
    int goldDiscount = sc.nextInt();

    System.out.print("Enter Platinum User Discount: ");
    int platinumDiscount = sc.nextInt();
    
    try (Connection conn = DBConnection.getConnection();) {
      	    
      	    String sql = "INSERT INTO Carrier ( carrierName, discountPercentageThirtyDaysAdvanceBooking, discountPercentageSixtyDaysAdvanceBooking, discountPercentageNinetyDaysAdvanceBooking, refundPercentageForTicketCancellation2DaysBeforeTravelDate, refundPercentageForTicketCancellation10DaysBeforeTravelDate, refundPercentageForTicketCancellation20DaysBeforeTravelDate, bulkBookingDiscount, silverUserDiscount, goldUserDiscount, platinumUserDiscount) " +
      	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      	    
      	    PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);;
      	    
      	    ps.setString(1, carrierName);
      	    ps.setInt(2, discount30Days);
      	    ps.setInt(3, discount60Days);
      	    ps.setInt(4, discount90Days);
      	    ps.setInt(5, refund2Days);
      	    ps.setInt(6, refund10Days);
      	    ps.setInt(7, refund20Days);
      	    ps.setInt(8, bulkBooking);
      	    ps.setInt(9, silverDiscount);
      	    ps.setInt(10, goldDiscount);
      	    ps.setInt(11, platinumDiscount);
      	    
      	    ps.executeUpdate();
      	    ResultSet rs = ps.getGeneratedKeys();
      	    if(rs.next()) 
      	    	System.out.println("Carrier "+rs.getInt(1)+" Added Successfully");
      	} catch (SQLException e) {
      	    e.printStackTrace();
      	}
  }

  public static void editCarrier() {
    System.out.print("Enter Carrier ID: ");
    int carrierId = sc.nextInt();
    sc.nextLine();

    if (carrierId < 1 || carrierId > carrierList.size() || carrierList.get(carrierId - 1) == null) {
      System.out.println("Invalid Carrier ID.");
      return;
    }

    System.out.print("Enter new Carrier Name: ");
    String carrierName = sc.nextLine();

    System.out.print("Enter new Discount for 30 Days Advance Booking: ");
    int discount30Days = sc.nextInt();

    System.out.print("Enter new Discount for 60 Days Advance Booking: ");
    int discount60Days = sc.nextInt();

    System.out.print("Enter new Discount for 90 Days Advance Booking: ");
    int discount90Days = sc.nextInt();

    System.out.print("Enter new Bulk Booking Discount: ");
    int bulkBooking = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (2 Days Before): ");
    int refund2Days = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (10 Days Before): ");
    int refund10Days = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (20 Days Before): ");
    int refund20Days = sc.nextInt();

    System.out.print("Enter new Silver User Discount: ");
    int silverDiscount = sc.nextInt();

    System.out.print("Enter new Gold User Discount: ");
    int goldDiscount = sc.nextInt();

    System.out.print("Enter new Platinum User Discount: ");
    int platinumDiscount = sc.nextInt();

    try (Connection conn = DBConnection.getConnection();
   	     Statement stmt = conn.createStatement()) {
   	    
   	    String sql = "UPDATE Carrier SET carrierName=?,"+
   	    " discountPercentageThirtyDaysAdvanceBooking=?,"+ 
   	    		"discountPercentageSixtyDaysAdvanceBooking=?,"+
   	    "discountPercentageNinetyDaysAdvanceBooking=?,"+
   	    		" refundPercentageForTicketCancellation2DaysBeforeTravelDate=?,"+
   	    " refundPercentageForTicketCancellation10DaysBeforeTravelDate=?,"+
   	    " refundPercentageForTicketCancellation20DaysBeforeTravelDate=?,"+
   	    		" bulkBookingDiscount=?,"+" silverUserDiscount=?, goldUserDiscount=?, platinumUserDiscount=?" +
   	                 "WHERE carrierId = ?";
   	    
   	    PreparedStatement ps = conn.prepareStatement(sql);
   	   
   	    ps.setString(1, carrierName);
   	    ps.setInt(2, discount30Days);
   	    ps.setInt(3, discount60Days);
   	    ps.setInt(4, discount90Days);
   	    ps.setInt(5, refund2Days);
   	    ps.setInt(6, refund10Days);
   	    ps.setInt(7, refund20Days);
   	    ps.setInt(8, bulkBooking);
   	    ps.setInt(9, silverDiscount);
   	    ps.setInt(10, goldDiscount);
   	    ps.setInt(11, platinumDiscount);
   	    ps.setInt(12, carrierId);
   	    ps.executeUpdate();
   	    
   	    System.out.println("Carrier "+carrierId+" Updated Successfully");
   	} catch (SQLException e) {
   	    e.printStackTrace();
   	}
  }

  public static void deleteCarrier() {
    System.out.print("Enter Carrier ID: ");
    int carrierId = sc.nextInt();
    sc.nextLine();
    
    String sql = "DELETE FROM Carrier WHERE carrierId = ?";
    try(Connection conn = DBConnection.getConnection();
    		PreparedStatement ps = conn.prepareStatement(sql);
    		) {
    	ps.setInt(1, carrierId);
    	int rowsAffected = ps.executeUpdate();
    	if(rowsAffected>0) {
    		System.out.println("Carrier "+ carrierId+" deleted Successfully");
    	} else {
    		System.out.println("No Carrier found with ID "+ carrierId+" deleted Failed");
    	}
    } catch(SQLException e) {
    	e.printStackTrace();
    }
    	
  }

  public static void createFlight() {
   
    System.out.print("Enter CarrierId: ");
    int carrierId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Origin: ");
    String origin = sc.nextLine();

    System.out.print("Enter Destination: ");
    String destination = sc.nextLine();

    System.out.print("Enter Air Fare: ");
    int airfare = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Economy Class: ");
    int seatCapacityEconomyClass = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Business Class: ");
    int seatCapacityBusinessClass = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Executive Class: ");
    int seatCapacityExecutiveClass = sc.nextInt();
    
    try (Connection conn = DBConnection.getConnection();) {
  	    
  	    String sql = "INSERT INTO Flight ( carrierId, origin, destination, airFare, seatCapacityEconomyClass, seatCapacityBusinessClass, seatCapacityExecutiveClass) " +
  	                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
  	    
  	    PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);;
  	    
  	    ps.setInt(1, carrierId);
  	    ps.setString(2, origin);
  	    ps.setString(3, destination);
  	    ps.setInt(4, airfare);
  	    ps.setInt(5, seatCapacityEconomyClass);
  	    ps.setInt(6, seatCapacityBusinessClass);
  	    ps.setInt(7, seatCapacityExecutiveClass);
  	    
  	    ps.executeUpdate();
  	    ResultSet rs = ps.getGeneratedKeys();
  	    if(rs.next()) 
  	    	System.out.println("Flight "+rs.getInt(1)+"Added Successfully");
  	} catch (SQLException e) {
  	    e.printStackTrace();
  	}
  }

  public static void sheduleFlight() {
    System.out.print("Enter FlightId: ");
    int flightId = sc.nextInt();

    sc.nextLine();
    System.out.print("Enter Date of Travel [dd-MM-yyyy]: ");
    String dateOfTravelStr = sc.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate dateOfTravel = LocalDate.parse(dateOfTravelStr, formatter);
    
    String sql = "SELECT * FROM Flight WHERE flightId = ? ";
    String insertScheduleFlightSql = "INSERT INTO FlightSchedule (flightId,dateOfTravel,economyClassBookedCount,businessClassBookedCount,executiveClassBookedCount)"+
    "VALUES(?,?,?,?,?)";
    try (Connection conn = DBConnection.getConnection();
    	PreparedStatement ps = conn.prepareStatement(sql);
    		) {
		ps.setInt(1,flightId);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			PreparedStatement ps2 = conn.prepareStatement(insertScheduleFlightSql,Statement.RETURN_GENERATED_KEYS);
			ps2.setInt(1,flightId);
			ps2.setDate(2, Date.valueOf(dateOfTravel) );
			ps2.setInt(3, 0);
			ps2.setInt(4, 0);
			ps2.setInt(5, 0);
			ps2.executeUpdate();
			System.out.println("Flight " + flightId + " is scheduled");
			
		} else {
			System.out.println("Flight is Not Available");
		}
	} catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public static void fightCancellation() {
    System.out.print("Enter Flight Id: ");
    int flightId = sc.nextInt();
    
    sc.nextLine();
    System.out.print("Enter Date of travel: ");
    String travelDateStr = sc.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate travelDate= LocalDate.parse(travelDateStr, formatter);

    int totalRefundAmount = 0;
    
    String sql = "SELECT * FROM FlightBooking WHERE flightId=? AND dateOfTravedl=? ";
    try (Connection conn = DBConnection.getConnection();
    	PreparedStatement ps = conn.prepareStatement(sql);
    		) {
		ps.setInt(1,flightId);
		ps.setDate(2,Date.valueOf(travelDate));
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			totalRefundAmount += rs.getInt("bookingAmount");
			String insertScheduleFlightSql = "UPDATE FlightBooking SET bookingStatus=? WHERE bookingId=?)";
			PreparedStatement ps2 = conn.prepareStatement(insertScheduleFlightSql,Statement.RETURN_GENERATED_KEYS);
			ps2.setString(1, "Cancelled");
			ps.setInt(2, rs.getInt("bookingId"));
			ps2.executeUpdate();
		}
	} catch (SQLException e) {
        e.printStackTrace();
    }
    
    LocalDate currentDate = LocalDate.now();
    LocalDate dateOfTravel = travelDate;

    long daysBetween = ChronoUnit.DAYS.between(currentDate, dateOfTravel);

    if (daysBetween > 7)
      System.out.println("Refund Account For All Flight Cancellation: Rs. " + totalRefundAmount);
    else
      System.out.println("Refund Account For All Flight Cancellation Within One week: Rs. "
          + (totalRefundAmount + (totalRefundAmount * 10) / 100));
  }

  public static void displayCarrier() {
	  try (Connection conn = DBConnection.getConnection();
              Statement stmt = conn.createStatement();
  			ResultSet rs = stmt.executeQuery("SELECT * FROM Carrier")) {
              while (rs.next()) {
            	  System.out.println("Carrier ID: " + rs.getInt("carrierId") + 
            			  " | Name: " + rs.getString("carrierName"));
              	
              }
            
  	}catch (SQLException e) {
          e.printStackTrace();
      }
  }

  public static void displayFlight() {
	  try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
  			ResultSet rs = stmt.executeQuery("SELECT * FROM Flight")) {
              while (rs.next()) {
            	  System.out.println("Flight ID: " + rs.getInt("flightId") + 
            			  " | Carrier ID: " + rs.getInt("carrierId")
                  + " | Origin: " + rs.getString("origin")+
                  " | Destination: " + rs.getString("destination"));
              	}
      } catch (SQLException e) {
           e.printStackTrace();
      }
}
  
  public static void displayFlightBookedDetails() {
	  try (Connection conn = DBConnection.getConnection();
	             Statement stmt = conn.createStatement();
	  			ResultSet rs = stmt.executeQuery("SELECT * FROM FlightBooking")) {
	              while (rs.next()) {
	            	  
	            	  System.out.println("Booking Id: " + rs.getInt("bookingId") +
	            			  "| Flight Id: " + rs.getInt("flightId") +
	            			  "| User Id: " + rs.getInt("userId") +
	            			  "| No Of Seats: " + rs.getInt("noOfSeat") +
	            			  "| Booking Status: " + rs.getString("bookingStatus") +
	            			  "| Booking Amount: " + rs.getInt("bookingAmount"));
	              	}
	      } catch (SQLException e) {
	           e.printStackTrace();
	      }

  }

  public static boolean adminMenu() {
    int choose_menu = 0;
    do {
      System.out.print("-------------------------------------------------------------------");
      System.out.print(
          "\nAdmin Menu\n1.Add Carrier\n2.Edit Carrier Details by CarrierId\n3.Remove Carrier by Id\n4.Flight Cancellation - Refund Price Calculation\n5.Add Flight\n6.Schedule Flight\n7.Display Carrier\n8.Display Flight\n9.Display All Flight Booking Details\n10.Exit Admin\n11.Exit AMS");
      System.out.print("\n-------------------------------------------------------------------");
      System.out.print("\nEnter the operation : ");
      choose_menu = sc.nextInt();
      sc.nextLine();
      switch (choose_menu) {
        case 1:
          System.out.println("Add Carrier");
          createCarrier();
          break;
        case 2:
          System.out.println("Edit Carrier Details by CarrierId");
          editCarrier();
          break;
        case 3:
          System.out.println("Remove Carrier by Id");
          deleteCarrier();
          break;
        case 4:
          System.out.println("Flight Cancellation - Refund Price Calculation");
          fightCancellation();
          break;
        case 5:
          System.out.println("Add Flight");
          createFlight();
          break;
        case 6:
            System.out.println("Schedule Flight");
            sheduleFlight();
            break;
        case 7:
          System.out.println("Display Carriers");
          displayCarrier();
          break;
        case 8:
          System.out.println("Display Flights");
          displayFlight();
          break;
        case 9:
            System.out.println("Display Flight Booking Details");
            displayFlightBookedDetails();
            break;
        case 10:
          System.out.println("Exit Admin");
          break;
        case 11:
          System.out.println("Exit AMS");
          return true;
        default:
          System.out.print("Invalid");
      }
    } while (choose_menu != 10);
    return false;
  }
}