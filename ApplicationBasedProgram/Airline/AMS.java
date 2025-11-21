import java.util.Scanner;

public class AMS {

    static Scanner sc = new Scanner(System.in);

    static Users[] userList = new Users[10];
    static Carrier[] carrierList = new Carrier[10];
    static Flight[] flightList = new Flight[10];
    static FlightBooking[] flightBookingList = new FlightBooking[10];
    static FlightSchedule[] flightScheduleList = new FlightSchedule[10];

    static int userCount = 0;
    static int carrierCount = 0;
    static int flightCount = 0;
    static int flightBookingCount = 0;
    static int flightScheduleCount = 0;

    static Users loggedInUser = null;

    private static void registerCustomer() {
        if (userCount >= 10) {
            System.out.println("Customer list is full. Cannot register more customers.");
            return;
        }

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

        System.out.print("Enter the dob: ");
        String dob = sc.nextLine();

        int userId = userCount + 1;
        Users newCustomer = new Users(userId, userName, password, email, phone, address1, address2, city, state,
                zipcode, dob);
        userList[userCount++] = newCustomer;

        System.out.println("Registered Successfully!\nYour User ID: " + userId);
    }

    private static boolean checkValidCustomer(int userId, String password, String role) {
        for (Users user : userList) {
            if (user != null && user.getUserId() == userId && user.getPassword().equals(password)
                    && user.getRole().equals(role)) {
                loggedInUser = user;
                return true;
            }
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

    private static void displayCustomers() {
        if (userCount == 0) {
            System.out.println("\nNo User Registered Yet.");
        } else {
            System.out.println("\nList of Users:");
            for (int i = 0; i < userCount; i++) {
                Users user = userList[i];
                System.out.println(
                        "User ID: " + user.getUserId() +
                                " | Name: " + user.getUserName() +
                                " | Role: " + user.getRole() +
                                " | Category: " + user.getCategory());
            }
        }
    }

    private static void addDummyData() {
        if (userCount < 10) {
            Users user1 = new Users(1, "pradeep", "krish", "pradeep@gmail.com",
                    987654322L, "south", "murukanathapuram", "karur", "tamil", 639001L, "24-04-2002");
            user1.setRole("Customer");
            user1.setCategory("Silver");
            userList[userCount++] = user1;
        }

        if (userCount < 10) {
            Users user2 = new Users(2, "pradeep2", "krish2", "pradeep2@gmail.com",
                    987654322L, "north", "somewhere", "chennai", "tamil", 600001L, "25-05-2003");
            user2.setRole("Admin");
            user2.setCategory("Gold");
            userList[userCount++] = user2;
        }

        if (carrierCount < 10) {
            carrierList[carrierCount++] = new Carrier(1, "jet carrier", 2, 3, 5, 2, 40, 70, 95, 1, 2, 4);
        }

        if (flightCount < 10) {
            flightList[flightCount++] = new Flight(1, 1, "chennai", "Paris", 88, 20, 10, 10);
        }
        
        if(flightScheduleCount<10) 
            flightScheduleList[flightScheduleCount++] = new FlightSchedule(1,1,"27-02-2025");
            
        if(flightBookingCount<10) 
            flightBookingList[flightBookingCount++] = new FlightBooking(1,1,1,5,"business","27-02-2025","Booked",175 );
            
    }

    private static void searchFlight() {
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();
        
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();
        
        System.out.print("Enter Travel Date: ");
        String travelDate = sc.nextLine();
        
        Flight findSearchFlight = null;
        FlightSchedule flightScheduled = null;
        for (int i = 0; i < flightScheduleCount; i++) {
            flightScheduled = flightScheduleList[i];
            if(flightScheduled.getDateOfTravel().equals(travelDate));
            {
                Flight flight = flightList[flightScheduled.getFlightId()-1];
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
        addDummyData();
        int n;
        do {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1. Admin Sign-in");
            System.out.println("2. Customer Sign-in");
            System.out.println("3. Customer Registration");
            System.out.println("4. Search Flight");
            System.out.println("5. Display Users List");
            System.out.println("6. Exit");
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
                    displayCustomers();
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (true);
    }
}
