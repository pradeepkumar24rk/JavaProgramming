public class FlightBooking {
    private int bookingId;
    private int flightId;
    private int noOfSeat;
    private String seatCategory;
    private String dateOfTravel;
    private String bookingStatus;
    private int bookingAmount;
    
    public FlightBooking(int bookingId,int flightId,int noOfSeat,String seatCategory,String dateOfTravel,String bookingStatus,int bookingAmount) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.noOfSeat = noOfSeat;
        this.seatCategory = seatCategory;
        this.dateOfTravel = dateOfTravel;
        this.bookingStatus = bookingStatus;
        this.bookingAmount = bookingAmount;
    }
}