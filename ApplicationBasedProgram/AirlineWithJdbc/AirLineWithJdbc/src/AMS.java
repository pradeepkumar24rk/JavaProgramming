import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AMS {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Users> userList = new ArrayList<>();
    static ArrayList<Carrier> carrierList = new ArrayList<>();
    static ArrayList<Flight> flightList = new ArrayList<>();
    static ArrayList<FlightSchedule> flightScheduleList = new ArrayList<>();
    static ArrayList<FlightBooking> flightBookingList = new ArrayList<>();

    static Users loggedInUser = null;

    public static void fetchData() {
    	try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement()) {
    		
    		try (ResultSet rs = stmt.executeQuery("SELECT * FROM User")) {
                while (rs.next()) {
                	Users newUser = new Users(
                            rs.getInt("userID"),
                            rs.getString("userName"),
                            rs.getString("password"),
                            rs.getString("emailId"),
                            rs.getLong("phone"),
                            rs.getString("address1"),
                            rs.getString("address2"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getLong("zipCode"),
                            rs.getDate("dob").toLocalDate()
                        );
                	newUser.setCategory(rs.getString("role"));
                        newUser.setRole(rs.getString("customerCategory"));
                    userList.add(newUser);
                    
                }
            }

               // Fetch Carriers
               try (ResultSet rs = stmt.executeQuery("SELECT * FROM Carrier")) {
                   while (rs.next()) {
                       carrierList.add(new Carrier(
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
               }

               // Fetch Flights
               try (ResultSet rs = stmt.executeQuery("SELECT * FROM Flight")) {
                   while (rs.next()) {
                       flightList.add(new Flight(
                           rs.getInt("flightId"),
                           rs.getInt("carrierId"),
                           rs.getString("origin"),
                           rs.getString("destination"),
                           rs.getInt("airfare"),
                           rs.getInt("seatCapacityEconomyClass"),
                           rs.getInt("seatCapacityBusinessClass"),
                           rs.getInt("seatCapacityExecutiveClass")
                       ));
                   }
               }

               // Fetch Flight Bookings
               try (ResultSet rs = stmt.executeQuery("SELECT * FROM FlightBooking")) {
                   while (rs.next()) {
                       flightBookingList.add(new FlightBooking(
                           rs.getInt("bookingId"),
                           rs.getInt("flightId"),
                           rs.getInt("userId"),
                           rs.getInt("noOfSeat"),
                           rs.getString("seatCategory"),
                           rs.getString("dateOfTravel"),
                           rs.getString("bookingStatus"),
                           rs.getInt("bookingAmount")
                       ));
                   }
               }

               // Fetch Flight Schedules
               try (ResultSet rs = stmt.executeQuery("SELECT * FROM FlightSchedule")) {
                   while (rs.next()) {
                       flightScheduleList.add(new FlightSchedule(
                           rs.getInt("flightScheduleId"),
                           rs.getInt("flightId"),
                           rs.getString("dateOfTravel"),
                           rs.getInt("economyClassBookedCount"),
                           rs.getInt("businessClassBookedCount"),
                           rs.getInt("executiveClassBookedCount")
                       ));
                   }
               }

           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
    
    private static void registerCustomer() {
       

        System.out.print("Enter the user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        System.out.print("Enter the phone: ");
        Long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the email: ");
        String email = sc.nextLine();

        System.out.print("Enter the address1: ");
        String address1 = sc.nextLine();

        System.out.print("Enter the address2: ");
        String address2 = sc.nextLine();

        System.out.print("Enter the city: ");
        String city = sc.nextLine();

        System.out.print("Enter the state: ");
        String state = sc.nextLine();

        System.out.print("Enter the zipcode: ");
        Long zipcode = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the dob [dd-MM-yyyy]: ");
        String dobStr = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(dobStr, formatter);
        
        
        try (Connection conn = DBConnection.getConnection();) {
        	    
        	    String sql = "INSERT INTO User ( userName, password, role, customerCategory, phone, emailId, address1, address2, city, state, country, zipCode, dob) " +
        	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	    
        	    PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        	   
        	    ps.setString(1, userName);
        	    ps.setString(2, password);
        	    ps.setString(3, "Customer");
        	    ps.setString(4, "Silver");
        	    ps.setLong(5, phone);
        	    ps.setString(6, email);
        	    ps.setString(7, address1);
        	    ps.setString(8, address2);
        	    ps.setString(9,city);
        	    ps.setString(10, state);
        	    ps.setString(11, "India");
        	    ps.setLong(12, zipcode);
        	    ps.setDate(13, Date.valueOf(dob)); 
        	    
        	    ps.executeUpdate();
        	    ResultSet rs = ps.getGeneratedKeys();
        	    if(rs.next()) {
        	    	int generatedId = rs.getInt(1);
        	    	System.out.println("Registered Successfully!\nYour User ID: " + generatedId);
        	    }
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	}

    }

    private static boolean checkValidCustomer(int userId, String password, String role) {
    	try (Connection conn = DBConnection.getConnection();) {
    		String sql = "SELECT * FROM User WHERE userId = ? AND password = ? AND role = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1,userId);
    		ps.setString(2,password);
    		ps.setString(3,role);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			loggedInUser = new Users(
                      rs.getInt("userID"),
                      rs.getString("userName"),
                      rs.getString("password"),
                      rs.getString("emailId"),
                      rs.getLong("phone"),
                      rs.getString("address1"),
                      rs.getString("address2"),
                      rs.getString("city"),
                      rs.getString("state"),
                      rs.getLong("zipCode"),
                      rs.getDate("dob").toLocalDate()
                  );
    			return true;
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    		
        System.out.println("\nYou're Not Authenticated. Please Register.");
        return false;
    }

    private static boolean login(String type) {
        System.out.print("-------------------------------------------------------------------");
        System.out.print("\nEnter the userId: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the password: ");
        String password = sc.nextLine();
        System.out.print("-------------------------------------------------------------------");

        if (checkValidCustomer(userId, password, type)) {
            if (type.equals("Admin")) {
                return Admin.adminMenu();
            } else if (type.equals("Customer")) {
                return Customer.customerMenu();
            	
            }
        }
        return false;
    }

    private static void displayUsers() {
    	try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery("SELECT * FROM User")) {
                while (rs.next()) {
                	System.out.println(
                            "User ID: " + rs.getInt("userID") +
                                    " | Name: " + rs.getString("userName") +
                                    " | Role: " + rs.getString("role") +
                                    " | Category: " + rs.getString("customerCategory"));
                }
              
    	}catch (SQLException e) {
            e.printStackTrace();
        }
   
    }

    private static void searchFlight() {
    	fetchData();
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();
        
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();
        
        System.out.print("Enter Travel Date: ");
        String travelDate = sc.nextLine();
        
        Flight findSearchFlight = null;
        FlightSchedule flightScheduled = null;
        for (int i = 0; i < flightScheduleList.size(); i++) {
            flightScheduled = flightScheduleList.get(i);
            if(flightScheduled.getDateOfTravel().equals(travelDate));
            {
                Flight flight = flightList.get(flightScheduled.getFlightId()-1);
                if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination)) {
                    findSearchFlight = flight;
                    break;
                }
            }
        }
        
        if (findSearchFlight == null) {
            System.out.println("\nNo Flights Yet.");
        } else {
            System.out.println("\nList of Flights:");
            System.out.println(
                    "Flight ID: " + findSearchFlight.getFlightId() +   
                    " | Carrier ID: " + findSearchFlight.getCarrierId() +
                    " | Schedule ID: " + flightScheduled.flightScheduleId()+
                    " | Air Fare: "+findSearchFlight.getAirFare()
            );
        }
    }
    
    public static void main(String[] args) {
    	DBInitializer.initailzeDatabase();
        int n;
        do {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1. Admin Sign-in");
            System.out.println("2. Customer Sign-in");
            System.out.println("3. Customer Registration");
            System.out.println("4. Search Flight");
            System.out.println("5. Display Users List");
            System.out.println("6. Fetch Data");
            System.out.println("7. Exit");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Enter the operation: ");

            n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    System.out.println("Admin sign-in");
                    if (login("Admin"))
                        System.exit(0);
                    break;

                case 2:
                    System.out.println("Customer sign-in");
                    if (login("Customer"))
                        System.exit(0);
                    break;

                case 3:
                    System.out.println("Customer Registration");
                    registerCustomer();
                    break;
                case 4:
                    System.out.println("Search Flight");
                    searchFlight();
                    break;

                case 5:
                    displayUsers();
                    break;
                case 6:
                    fetchData();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (true);
    }
}
