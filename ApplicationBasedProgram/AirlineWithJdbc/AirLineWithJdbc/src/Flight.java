public class Flight {
    private int flightId;
    private int carrierId;
    private String origin;
    private String destination;
    private int airfare;
    private int seatCapacityEconomyClass;
    private int seatCapacityBusinessClass;
    private int seatCapacityExecutiveClass;
    
    public Flight(int flightId,int carrierId,String origin,String destination,int airfare,int seatCapacityEconomyClass,int seatCapacityBusinessClass,int seatCapacityExecutiveClass) {
        this.flightId = flightId;
        this.carrierId = carrierId;
        this.origin = origin;
        this.destination = destination;
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
    
    public int getEconomyClassSeatCapacity() {
        return seatCapacityEconomyClass;
    }
    
    public int getBusinessClassSeatCapacity() {
        return seatCapacityBusinessClass;
    }
    
    public int getExecutiveClassSeatCapacity() {
        return seatCapacityExecutiveClass;
    }
    
    
} 