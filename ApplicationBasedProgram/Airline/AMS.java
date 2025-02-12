import java.util.*;

public class AMS {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Customer> customerMapList = new HashMap<>();
    static HashMap<Integer, Carrier> carrierMapList = new HashMap<>();
    
    static Customer loggedInCustomer = null;

    private static void registerCustomer() {
        System.out.print("Enter the user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        System.out.print("Enter the phone: ");
        Long phone = sc.nextLong();
        sc.nextLine(); // Consume newline

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

        int userId = customerMapList.size() + 1;
        Customer newCustomer = new Customer(userId, userName, password, email, phone, address1, address2, city, state, zipcode, dob);
        customerMapList.put(userId, newCustomer);

        System.out.println("Registered Successfully!\nYour User ID: " + userId);
    }

    private static boolean checkValidCustomer(int userId, String password) {
        if (customerMapList.containsKey(userId) && customerMapList.get(userId).getPassword().equals(password)) {
            loggedInCustomer = customerMapList.get(userId);
            return true; 
        }
        System.out.println("\nYou're Not Authenticated. Please Register.");
        return false;
    }

    private static boolean login(String type) {
        if (type.equals("admin")) {
            return Admin.adminMenu();
        } else if (type.equals("customer")) {
            System.out.print("-------------------------------------------------------------------");
            System.out.print("\nEnter the userId: ");
            int userId = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter the password: ");
            String password = sc.nextLine();
            System.out.print("-------------------------------------------------------------------");

            if (checkValidCustomer(userId, password)) {
                return Customer.customerMenu();
            }
        }
        return false;
    }

    private static void displayCustomers() {
        if (customerMapList.isEmpty()) {
            System.out.println("\nNo Customers Registered Yet.");
        } else {
            System.out.println("\nList of Customers:");
            for (Map.Entry<Integer, Customer> map : customerMapList.entrySet()) {
                System.out.println(
                        "User ID: " + map.getValue().getUserId() +
                        " | Name: " + map.getValue().getUserName()
                );
            }
        }
    }

    public static void main(String[] args) {
        // Adding default customers
        customerMapList.put(1, new Customer(1, "pradeep", "krish", "pradeep@gmail.com",
                987654322L, "south", "murukanathapuram", "karur", "tamil", 639001L, "24/4/2002"));

        customerMapList.put(2, new Customer(2, "pradeep2", "krish2", "pradeep2@gmail.com",
                987654322L, "north", "somewhere", "chennai", "tamil", 600001L, "25/5/2003"));

        int n;
        do {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("1. Admin Sign-in");
            System.out.println("2. Customer Sign-in");
            System.out.println("3. Customer Registration");
            System.out.println("4. Display Customer List");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Enter the operation: ");

            n = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (n) {
                case 1:
                    System.out.println("Admin sign-in");
                    if (login("admin")) System.exit(0);
                    break;

                case 2:
                    System.out.println("Customer sign-in");
                    if (login("customer")) System.exit(0);
                    break;

                case 3:
                    System.out.println("Customer Registration");
                    registerCustomer();
                    break;

                case 4:
                    displayCustomers();
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (true);
    }
}
