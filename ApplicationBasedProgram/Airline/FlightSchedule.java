public class FlightSchedule {
    private int flightScheduleId;
    private int flightId;
    private String dateOfTravel;
    private int bussinessClassBookedCount;
    private int economyClassBookedCount;
    private int executiveClassBookedCount;
    
    public FlightSchedule(int flightScheduleId,int flightId,String dateOfTravel,int bussinessClassBookedCount,int economyClassBookedCount,int executiveClassBookedCount) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.dateOfTravel = dateOfTravel;
        this.bussinessClassBookedCount = bussinessClassBookedCount;
        this.executiveClassBookedCount = executiveClassBookedCount;
        this.economyClassBookedCount = economyClassBookedCount;
    }
    
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