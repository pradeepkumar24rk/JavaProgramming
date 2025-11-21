package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import config.DBConnection;
import models.CarrierModel;
import models.FlightScheduleModel;

public class AdminHomeDAO {
	
	public static void getCarrierData(ArrayList<CarrierModel> carrierList) {
		  try (Connection conn = DBConnection.getConnection();
	              Statement stmt = conn.createStatement();
	  			ResultSet rs = stmt.executeQuery("SELECT * FROM Carrier")) {
	              while (rs.next()) {
	            	  carrierList.add(new CarrierModel(
	                          rs.getInt("carrierId"),
	                          rs.getString("carrierName"),
	                          rs.getInt("discountPercentageThirtyDaysAdvanceBooking"),
	                          rs.getInt("discountPercentageSixtyDaysAdvanceBooking"),
	                          rs.getInt("discountPercentageNinetyDaysAdvanceBooking"),
	                          rs.getInt("bulkBookingDiscount"),
	                          rs.getInt("refundPercentageForTicketCancellation2DaysBeforeTravelDate"),
	                          rs.getInt("refundPercentageForTicketCancellation10DaysBeforeTravelDate"),
	                          rs.getInt("refundPercentageForTicketCancellation20DaysBeforeTravelDate"),
	                          rs.getInt("silverUserDiscount"),
	                          rs.getInt("goldUserDiscount"),
	                          rs.getInt("platinumUserDiscount")
	                      ));
	              	
	              }
	            
	  	}catch (SQLException e) {
	          e.printStackTrace();
	      }
	}
	
	public static void getFlightSchedule(ArrayList<FlightScheduleModel> flightScheduleList) {
		try (Connection conn = DBConnection.getConnection();
	              Statement stmt = conn.createStatement();
	  			ResultSet rs = stmt.executeQuery("SELECT * FROM FlightSchedule")) {
	              while (rs.next()) {
	            	  flightScheduleList.add(new FlightScheduleModel(
	            			  rs.getInt("flightScheduleId"),
	                           rs.getInt("flightId"),
	                           rs.getDate("dateOfTravel").toLocalDate(),
	                           rs.getInt("economyClassBookedCount"),
	                           rs.getInt("businessClassBookedCount"),
	                           rs.getInt("executiveClassBookedCount")
	                      ));
	              	
	              }
	            
	  	}catch (SQLException e) {
	          e.printStackTrace();
	      }
	}
	
	public static boolean insertFlightSchedule(int flightId, String dateOfTravelStr) {
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
				return true;
			}
				System.out.println("Flight is Not Available");
				return false;
			
			
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
}
