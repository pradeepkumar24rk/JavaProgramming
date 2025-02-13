import java.util.*;

public class Customer extends AMS {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private Long phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Long zipcode;
    private String dob;
    private String role;
    private String userCategory;

    static Scanner sc = new Scanner(System.in);

    public Customer(int userId, String userName, String password, String email, Long phone, 
                    String address1, String address2, String city, String state, Long zipcode, String dob) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address2 = address2;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.dob = dob;
    }
    
    public static void editCustomerProfile() {
        if (loggedInCustomer == null) {
            System.out.println("No customer is logged in.");
            return;
        }
    
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
    
        System.out.print("Enter the new dob: ");
        String dob = sc.nextLine();
    
        int userId = loggedInCustomer.getUserId();
        
        // Update the existing customer object in the array
        if (userId >= 1 && userId <= customerList.length && customerList[userId - 1] != null) {
            customerList[userId - 1] = new Customer(userId, userName, password, email, phone, address1, address2, city, state, zipcode, dob);
            loggedInCustomer = customerList[userId - 1]; // Update the logged-in user reference
            System.out.println("Your Profile Edited Successfully!");
        } else {
            System.out.println("Error: Invalid customer ID.");
        }
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
            sc.nextLine(); // Consume newline
            switch (choose_menu) {
                case 1:
                    System.out.println("Edit Customer Profile");
                    editCustomerProfile();
                    break;
                case 2:
                    System.out.println("Ticket Booking");
                    break;
                case 3:
                    System.out.println("Ticket Cancelling");
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

    // Getters
    public int getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getCategory() {
        return userCategory;
    }
    
    // Setters
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setCategory(String userCategory) {
        this.userCategory = userCategory;
    }
}
