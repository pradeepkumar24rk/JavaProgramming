public class FlightSchedule {
    private int flightScheduleId;
    private int flightId;
    private String dateOfTravel;
    private int bussinessClassBookedCount;
    private int economyClassBookedCount;
    private int executiveClassBookedCount;
    
    public FlightSchedule(int flightScheduleId,int flightId,String dateOfTravel) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.dateOfTravel = dateOfTravel;
    }
    
    public FlightSchedule(int flightScheduleId,int flightId,String dateOfTravel,int economyClassBookedCount,int bussinessClassBookedCount,int executiveClassBookedCount) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.dateOfTravel = dateOfTravel;
        this.bussinessClassBookedCount = bussinessClassBookedCount;
        this.economyClassBookedCount = economyClassBookedCount;
        this.executiveClassBookedCount = executiveClassBookedCount;
    }
    
    
    //Getter
    public int getFlightId() {
        return flightId;
    }
    
    public String getDateOfTravel() {
        return dateOfTravel;
    }
    
    public int flightScheduleId() {
        return flightScheduleId;
    }
    
    public int getBussinessClassBookingCount() {
        return bussinessClassBookedCount;
    }
    
    public int getExecutiveClassBookedCount() {
        return executiveClassBookedCount;
    }
    
    public int getEconomyClassBookedCount() {
        return economyClassBookedCount;
    }

    //Setter
    public void setBussinessClassBookingCount(int val) {
        this.bussinessClassBookedCount = val;
    }
    
    public void setExecutiveClassBookedCount(int val) {
        this.executiveClassBookedCount = val;
    }
    
    public void setEconomyClassBookedCount(int val) {
        this.economyClassBookedCount = val;
    }
}