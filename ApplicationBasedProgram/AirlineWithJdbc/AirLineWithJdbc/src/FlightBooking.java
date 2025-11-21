public class FlightBooking {
    private int bookingId;
    private int flightId;
    private int userId;
    private int noOfSeat;
    private String seatCategory;
    private String dateOfTravel;
    private String bookingStatus;
    private int bookingAmount;
    
    public FlightBooking(int bookingId,int flightId,int userId,int noOfSeat,String seatCategory,String dateOfTravel,String bookingStatus,int bookingAmount) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.userId = userId;
        this.noOfSeat = noOfSeat;
        this.seatCategory = seatCategory;
        this.dateOfTravel = dateOfTravel;
        this.bookingStatus = bookingStatus;
        this.bookingAmount = bookingAmount;
    }
    
    
    //getter
    public int getBookingId() {
        return bookingId;
    }
    
    public String getDateOfTravel() {
        return dateOfTravel;
    }
    
    public int getFlightId() {
        return flightId;
    }
    
    public int getUserId() {
        return userId;
    }
     
    public int getNoOfSeats() {
        return noOfSeat;
    }
    
    public int getBookingAmount() {
        return bookingAmount;
    }
    
    public String getBookingStatus() {
        return bookingStatus;
    }
    
    public String getSeatCategory() {
        return seatCategory;
    }
    
    //setter
    public void setBookingStatus(String val) {
        this.bookingStatus = val;
    }
}