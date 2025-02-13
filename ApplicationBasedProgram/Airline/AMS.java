import java.util.Scanner;

public class AMS {

    static Scanner sc = new Scanner(System.in);
    
    static Customer[] customerList = new Customer[10];
    static Carrier[] carrierList = new Carrier[10];
    static Flight[] flightList = new Flight[10];

    static int customerCount = 0;
    static int carrierCount = 0;
    static int flightCount = 0;
    
    static Customer loggedInCustomer = null;

    private static void registerCustomer() {
        if (customerCount >= 10) {
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

        int userId = customerCount + 1;
        Customer newCustomer = new Customer(userId, userName, password, email, phone, address1, address2, city, state, zipcode, dob);
        customerList[customerCount++] = newCustomer;

        System.out.println("Registered Successfully!\nYour User ID: " + userId);
    }

    private static boolean checkValidCustomer(int userId, String password, String role) {
        for (Customer customer : customerList) {
            if (customer != null && customer.getUserId() == userId && customer.getPassword().equals(password) && customer.getRole().equals(role)) {
                loggedInCustomer = customer;
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
        if (customerCount == 0) {
            System.out.println("\nNo User Registered Yet.");
        } else {
            System.out.println("\nList of Users:");
            for (int i = 0; i < customerCount; i++) {
                Customer customer = customerList[i];
                System.out.println(
                        "User ID: " + customer.getUserId() +
                        " | Name: " + customer.getUserName() +
                        " | Role: " + customer.getRole() +
                        " | Category: " + customer.getCategory()
                );
            }
        }
    }
    
    private static void addDummyData() {
        if (customerCount < 10) {
            Customer user1 = new Customer(1, "pradeep", "krish", "pradeep@gmail.com",
                    987654322L, "south", "murukanathapuram", "karur", "tamil", 639001L, "24/4/2002");
            user1.setRole("Customer");
            user1.setCategory("Silver");
            customerList[customerCount++] = user1;
        }

        if (customerCount < 10) {
            Customer user2 = new Customer(2, "pradeep2", "krish2", "pradeep2@gmail.com",
                    987654322L, "north", "somewhere", "chennai", "tamil", 600001L, "25/5/2003");
            user2.setRole("Admin");
            user2.setCategory("Gold");
            customerList[customerCount++] = user2;
        }
        
        if (carrierCount < 10) {
            carrierList[carrierCount++] = new Carrier(1, "jet carrier", 12, 22, 33, 44, 55, 66, 77, 22, 11, 44);
        }

        if (flightCount < 10) {
            flightList[flightCount++] = new Flight(1, 1, "chennai", "Paris", "24/02/2025", 88, 33, 44, 55);
        }
    }
    
    private static void searchFlight() {
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();
        
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();
        
        System.out.print("Enter Travel Date: ");
        String travelDate = sc.nextLine();
        
        Flight findSearchFlight = null;
        
        for (int i = 0; i < flightCount; i++) {
            Flight flight = flightList[i];
            if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination) && flight.getTravelDate().equalsIgnoreCase(travelDate)) {
                findSearchFlight = flight;
                break;
            }
        }
        
        if (findSearchFlight == null) {
            System.out.println("\nNo Flights Yet.");
        } else {
            System.out.println("\nList of Flights:");
            System.out.println(
                    "Flight ID: " + findSearchFlight.getFlightId() +   
                    " | Carrier ID: " + findSearchFlight.getCarrierId()
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
                    if (login("Admin")) System.exit(0);
                    break;

                case 2:
                    System.out.println("Customer sign-in");
                    if (login("Customer")) System.exit(0);
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
