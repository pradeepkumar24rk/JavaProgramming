import java.util.*;


class CarrierDoesNotExistException extends Exception {
    public CarrierDoesNotExistException(String message) {
        super(message);
    }
}

class SeatingCapacityDiscrepancyException extends Exception {
    public SeatingCapacityDiscrepancyException(String message) {
        super(message);
    }
} 

public class AdvanceAMS {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Users> userList = new ArrayList<>();
    static ArrayList<Carrier> carrierList = new ArrayList<>();
    static ArrayList<Flight> flightList = new ArrayList<>();
    static ArrayList<FlightSchedule> flightScheduleList = new ArrayList<>();

    // User CRUD OPERATION
    static void registerUser() {
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
        String dob = sc.nextLine();

        int userId = userList.size() + 1;
        Users newCustomer = new Users(userId, userName, password, email, phone, address1, address2, city, state,
                zipcode, dob);
        userList.add(newCustomer);

        System.out.println("Registered Successfully!\nYour User ID: " + userId);
    }

    static void editUser() {
        System.out.print("Enter User Id: ");
        int userId = sc.nextInt();

        sc.nextLine();
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

        System.out.print("Enter the new zipcode: ");
        Long zipcode = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter the new dob [dd-MM-yyyy]: ");
        String dob = sc.nextLine();
        Users editUser = new Users(userId, userName, password, email, phone, address1, address2, city, state,
                zipcode, dob);
        userList.replaceAll(user -> user.getUserId() == userId ? editUser : user);
        System.out.println("Your Profile Edited Successfully!");
    }

    static void displayUsers() {
        if (userList.size() == 0) {
            System.out.println("\nNo User Registered Yet.");
        } else {
            System.out.println("\nList of Users:");
            for (int i = 0; i < userList.size(); i++) {
                Users user = userList.get(i);
                System.out.println(
                        "User ID: " + user.getUserId() +
                                " | Name: " + user.getUserName() +
                                " | Role: " + user.getRole() +
                                " | Category: " + user.getCategory());
            }
        }
    }

    static void deleteUser() {
        System.out.print("Enter User Id: ");
        int userId = sc.nextInt();
        sc.nextLine();
        if (userList.isEmpty()) {
            System.out.println("\nNo User Registered Yet.");
        } else {
            userList.removeIf(user -> user.getUserId() == userId);
            System.out.println("Your Data Deleted Successfully");
        }
    }

    // FLight Operation
    static void createFlight() throws SeatingCapacityDiscrepancyException, NullPointerException {
    
        System.out.print("Enter CarrierId: ");
        String carrierIdStr = sc.nextLine().trim();
        if(carrierIdStr.isEmpty())
            throw new NullPointerException("carrierId cannot be empty");
        int carrierId = Integer.parseInt(carrierIdStr);
        
        if(carrierId>carrierList.size()) {
            throw new SeatingCapacityDiscrepancyException("Carrier "+carrierId+" Does not Exist.");
        }

        System.out.print("Enter Origin: ");
        String origin = sc.nextLine().trim();
        
        if(origin.isEmpty())
            throw new NullPointerException("Origin cannot be empty");
        
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine().trim();
        if(destination.isEmpty())
            throw new NullPointerException("Destination cannot be empty");

        System.out.print("Enter Air Fare: ");
        String airFareStr = sc.nextLine().trim();
        if(airFareStr.isEmpty())
            throw new NullPointerException("Airfare cannot be empty");
        int airfare = Integer.parseInt(airFareStr);
        
        System.out.print("Enter Seat Capacity Economy Class: ");
        int seatCapacityEconomyClass = sc.nextInt();
        validateSeatingCapacity(seatCapacityEconomyClass, 20);

        System.out.print("Enter Seat Capacity Business Class: ");
        int seatCapacityBusinessClass = sc.nextInt();
        validateSeatingCapacity(seatCapacityBusinessClass, 10);

        System.out.print("Enter Seat Capacity Executive Class: ");
        int seatCapacityExecutiveClass = sc.nextInt();
        validateSeatingCapacity(seatCapacityExecutiveClass, 5);
        sc.nextLine();
        
        if (flightList == null) {
            flightList = new ArrayList<>();
        }

        Flight newFlight = new Flight(
            flightList.size() + 1, 
            carrierId, 
            origin, 
            destination, 
            airfare, 
            seatCapacityEconomyClass, 
            seatCapacityBusinessClass, 
            seatCapacityExecutiveClass
        );

        flightList.add(newFlight);
        System.out.println("Flight Added Successfully");

    
}

    static void sheduleFlight() throws NullPointerException {
        System.out.print("Enter FlightId: ");
        int flightId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Date of Travel [dd-MM-yyyy]: ");
        String dateOfTravel = sc.nextLine();
        
        if (flightId>flightList.size()) {
            throw new NullPointerException("Flight is not exists.");
        }

        FlightSchedule newScheduleFlight = new FlightSchedule(flightScheduleList.size() + 1, flightId, dateOfTravel);
        flightScheduleList.add(newScheduleFlight);
        System.out.println("Flight " + flightId + " is scheduled");
    }
    
    static void searchFlight() throws NullPointerException {
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine().trim();
        if(origin.isEmpty())
            throw new NullPointerException("Origin cannot be empty");

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine().trim();
        if(destination.isEmpty())
            throw new NullPointerException("Destination cannot be empty");

        System.out.print("Enter Travel Date [dd-MM-yyyy]: ");
        String travelDate = sc.nextLine().trim();
        if(travelDate.isEmpty())
            throw new NullPointerException("Travel Date cannot be empty");

        Flight findSearchFlight = null;
        FlightSchedule flightScheduled = null;
        for (int i = 0; i < flightScheduleList.size(); i++) {
            flightScheduled = flightScheduleList.get(i);
            if (flightScheduled.getDateOfTravel().equals(travelDate))
            {
                Flight flight = flightList.get(flightScheduled.getFlightId() - 1);
                if (flight.getOrigin().equalsIgnoreCase(origin)
                        && flight.getDestination().equalsIgnoreCase(destination)) {
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
                            " | Schedule ID: " + flightScheduled.flightScheduleId() +
                            " | Air Fare: " + findSearchFlight.getAirFare());
        }
    }

    static void displayFlight() {
        if (flightList.size() == 0) {
            System.out.println("\nNo Flights Registered Yet.");
        } else {
            System.out.println("\nList of Flights:");
            for (int i = 0; i < flightList.size(); i++) {
                Flight flight = flightList.get(i);
                if (flight != null)
                    System.out.println("Flight ID: " + flight.getFlightId() + " | Carrier ID: " + flight.getCarrierId()
                            + " | Origin: " + flight.getOrigin() + " | Destination: " + flight.getDestination());
            }
        }
    }

    static void displaySchedule() {
        if (flightScheduleList.size() == 0) {
            System.out.println("\nNo Flights Scheduled Yet.");
        } else {
            System.out.println("\nList of Scheduled Flights:");
            for (int i = 0; i < flightScheduleList.size(); i++) {
                FlightSchedule flight = flightScheduleList.get(i);
                if (flight != null)
                    System.out.println("Flight ID: " + flight.getFlightId() + " | Scheduled ID: "
                            + flight.flightScheduleId() + " | Date of Travel: " + flight.getDateOfTravel());
            }
        }
    }

    static void flightCount() throws CarrierDoesNotExistException {
        System.out.print("Enter Carrier ID: ");
        int carrierId = sc.nextInt();
        sc.nextLine();
        if(carrierId>carrierList.size()){
            throw new CarrierDoesNotExistException("Carrier "+carrierId+" Does not Exist.");
        }
        
        
        Map<String, List<Integer>> cityFlightsMap = new TreeMap<>();
        System.out.println("Carrier Name: " + carrierList.get(carrierId - 1).getCarrierName());
        for (Flight flight : flightList) {
            if (flight.getCarrierId() == carrierId) {
                cityFlightsMap.putIfAbsent(flight.getOrigin(), new ArrayList<>());
                cityFlightsMap.get(flight.getOrigin()).add(flight.getFlightId());
            }
        }

        for (Map.Entry<String, List<Integer>> map : cityFlightsMap.entrySet()) {
            System.out.print(map.getKey() + " : " + map.getValue().size() + " ( ");
            Iterator<Integer> iterator = map.getValue().iterator();
            while (iterator.hasNext()) {
                System.out.print("Flight ID " + iterator.next());
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println(" )");
        }
    }
    
    static void validateSeatingCapacity(int seatingCapacity, int minCapacity) throws SeatingCapacityDiscrepancyException {
        if (seatingCapacity < minCapacity) {
            sc.nextLine();
            throw new SeatingCapacityDiscrepancyException("Seating capacity is below the minimum required: " + minCapacity);
        }
    }

    static void addDummyData() {
        Users user1 = new Users(1, "pradeep", "krish", "pradeep@gmail.com",
                987654322L, "south", "murukanathapuram", "karur", "tamil", 639001L, "24-04-2002");
        user1.setRole("Customer");
        user1.setCategory("Silver");
        userList.add(user1);

        Users user2 = new Users(2, "pradeep2", "krish2", "pradeep2@gmail.com",
                987654322L, "north", "somewhere", "chennai", "tamil", 600001L, "25-05-2003");
        user2.setRole("Admin");
        user2.setCategory("Gold");
        userList.add(user2);

        carrierList.add(new Carrier(1, "jet carrier", 2, 3, 5, 2, 40, 70, 95, 1, 2, 4));
        carrierList.add(new Carrier(2, "indigo", 2, 3, 5, 2, 40, 70, 95, 1, 2, 4));

        flightList.add(new Flight(1, 1, "chennai", "Paris", 88, 20, 10, 10));

        flightScheduleList.add(new FlightSchedule(1, 1, "27-02-2025"));
    }

    public static void main(String[] args) {
            addDummyData();
            int n;
            do {
                try{
                    System.out.println("\n-------------------------------------------------------------------");
                    System.out.println("Main Menu");
                    System.out.println("1. User Registration");
                    System.out.println("2. User Updation");
                    System.out.println("3. User Deletion");
                    System.out.println("4. Display Users List");
                    System.out.println("5. Add Flight");
                    System.out.println("6. Search Flight");
                    System.out.println("7. Display Flight");
                    System.out.println("8. Display Scheduled Flight");
                    System.out.println("9. Display Flight Count By Carrier ID");
                    System.out.println("10. Exit");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.print("Enter the operation Number: ");
                    String nStr = sc.nextLine().trim();
                    if(nStr.isEmpty())
                        throw new NullPointerException();
                    n = Integer.parseInt(nStr);
                    switch (n) {
                    case 1:
                        System.out.println("User Registration");
                        registerUser();
                        break;
    
                    case 2:
                        System.out.println("User Updation");
                        editUser();
                        break;
                    case 3:
                        System.out.println("User Deletion");
                        deleteUser();
                        break;
                    case 4:
                        displayUsers();
                        break;
                    case 5:
                        System.out.println("Add Flight");
                        createFlight();
                        break;
                    case 6:
                        System.out.println("Search Flight");
                    
                            searchFlight();
                        
                        break;
                    case 7:
                        displayFlight();
                        break;
                    case 8:
                        displaySchedule();
                        break;
                    case 9:
                        System.out.println("Flight Count by Carrier Id");
                        
                            flightCount();
                        
                        break;
                    case 10:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
    
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.print("Input Invalid");
                }  catch (NumberFormatException e) {
                    System.out.print("Please enter Numberic value");
                }  catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            } while (true);
    }
}
