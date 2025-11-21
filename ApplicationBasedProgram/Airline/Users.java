import java.util.Scanner;

public class Users {

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

    public Users(int userId, String userName, String password, String email, Long phone, 
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