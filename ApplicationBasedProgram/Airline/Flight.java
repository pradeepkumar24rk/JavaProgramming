public class Flight {
    private int flightId;
    private int carrierId;
    private String origin;
    private String destination;
    private String travelDate;
    private int airfare;
    private int seatCapacityEconomyClass;
    private int seatCapacityBusinessClass;
    private int seatCapacityExecutiveClass;
    
    public Flight(int flightId,int carrierId,String origin,String destination,String travelDate,int airfare,int seatCapacityBusinessClass,int seatCapacityEconomyClass,int seatCapacityExecutiveClass) {
        this.flightId = flightId;
        this.carrierId = carrierId;
        this.origin = origin;
        this.destination = destination;
        this.travelDate = travelDate;
        this.airfare = airfare;
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
    }
    
    public int getFlightId(){
        return flightId;
    }
    
    public int getCarrierId() {
        return carrierId;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public int getAirFare() {
        return airfare;
    }
    
    public String getTravelDate() {
        return travelDate;
    }
} 