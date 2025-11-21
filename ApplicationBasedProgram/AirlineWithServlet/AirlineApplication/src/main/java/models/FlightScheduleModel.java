package models;

import java.time.LocalDate;

public class FlightScheduleModel {
    private int flightScheduleId;
    private int flightId;
    private LocalDate dateOfTravel;
    private int bussinessClassBookedCount;
    private int economyClassBookedCount;
    private int executiveClassBookedCount;
    
    public FlightScheduleModel(int flightScheduleId,int flightId,LocalDate dateOfTravel) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.dateOfTravel = dateOfTravel;
    }
    
    public FlightScheduleModel(int flightScheduleId,int flightId,LocalDate dateOfTravel,int economyClassBookedCount,int bussinessClassBookedCount,int executiveClassBookedCount) {
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
    
    public LocalDate getDateOfTravel() {
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