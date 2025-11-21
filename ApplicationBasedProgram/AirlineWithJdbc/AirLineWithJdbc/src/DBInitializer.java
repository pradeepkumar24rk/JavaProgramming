import java.sql.*;

public class DBInitializer {
	public static void initailzeDatabase() {
		try (Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();)
		{
			stmt.execute("CREATE TABLE IF NOT EXISTS Flight (\r\n"
					+ "    flightId                   INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "    carrierId                  INTEGER ,\r\n"
					+ "    origin                     VARCHAR(255),\r\n"
					+ "    destination                VARCHAR(255),\r\n"
					+ "    airFare                    INTEGER,\r\n"
					+ "    seatCapacityEconomyClass   INTEGER CHECK (seatCapacityEconomyClass >=20),\r\n"
					+ "    seatCapacityBusinessClass  INTEGER CHECK (seatCapacityBusinessClass>=10),\r\n"
					+ "    seatCapacityExecutiveClass INTEGER CHECK (seatCapacityExecutiveClass>=5),\r\n"
					+ "    FOREIGN KEY ( carrierId )\r\n"
					+ "        REFERENCES Carrier ( carrierId )\r\n"
					+ ")");
			stmt.execute("CREATE TABLE IF NOT EXISTS Carrier (\r\n"
					+ "    carrierId                                                   INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "    carrierName                                                 VARCHAR(255),\r\n"
					+ "    discountPercentageThirtyDaysAdvanceBooking                  INTEGER,\r\n"
					+ "    discountPercentageSixtyDaysAdvanceBooking                   INTEGER,\r\n"
					+ "    discountPercentageNinetyDaysAdvanceBooking                  INTEGER,\r\n"
					+ "    refundPercentageForTicketCancellation2DaysBeforeTravelDate  INTEGER,\r\n"
					+ "    refundPercentageForTicketCancellation10DaysBeforeTravelDate INTEGER,\r\n"
					+ "    refundPercentageForTicketCancellation20DaysBeforeTravelDate INTEGER,\r\n"
					+ "    bulkBookingDiscount                                         INTEGER,\r\n"
					+ "    silverUserDiscount                                          INTEGER,\r\n"
					+ "    goldUserDiscount                                            INTEGER,\r\n"
					+ "    platinumUserDiscount                                        INTEGER\r\n"
					+ ")");
			stmt.execute("CREATE TABLE IF NOT EXISTS FlightSchedule (\r\n"
					+ "    flightScheduleId           INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "    flightId                   INTEGER,\r\n"
					+ "	   dateOfTravel				DATE,\r\n"
					+ "    economyClassBookedCount    INTEGER,\r\n"
					+ "    businessClassBookedCount   INTEGER,\r\n"
					+ "    executiveClassBookedCount  INTEGER,\r\n"
					+ "    FOREIGN KEY ( flightId )\r\n"
					+ "        REFERENCES Flight ( flightId )\r\n"
					+ ")");
			stmt.execute("CREATE TABLE IF NOT EXISTS User (\r\n"
					+ "  userID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "  userName VARCHAR(255),\r\n"
					+ "  password VARCHAR(255),\r\n"
					+ "  role VARCHAR(255) CHECK (role IN ('Admin','Customer')),\r\n"
					+ "  customerCategory VARCHAR(255) CHECK (customerCategory IN ('Silver','Gold','Platium')),\r\n"
					+ "  phone BIGINT,\r\n"
					+ "  emailId VARCHAR(255),\r\n"
					+ "  address1 VARCHAR(255),\r\n"
					+ "  address2 VARCHAR(255),\r\n"
					+ "  city VARCHAR(255),\r\n"
					+ "  state VARCHAR(255),\r\n"
					+ "  country VARCHAR(255),\r\n"
					+ "  zipCode INTEGER,\r\n"
					+ "  dob DATE\r\n"
					+ ")");
			stmt.execute("CREATE TABLE IF NOT EXISTS FlightBooking (\r\n"
					+ "  bookingId INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "  flightId INTEGER,\r\n"
					+ "  userId INTEGER,\r\n"
					+ "  noOfSeats INTEGER,\r\n"
					+ "  seatCategory VARCHAR(255) CHECK (seatCategory IN ('Economy','Business','Executive')),\r\n"
					+ "  dateOfTravel DATE,\r\n"
					+ "  bookingStatus VARCHAR(255) CHECK (bookingStatus IN ('Booked', 'Travel Completed', 'Cancelled')),\r\n"
					+ "  bookingAmount INTEGER,\r\n"
					+ "  FOREIGN KEY (userId) REFERENCES User(userID),\r\n"
					+ "  FOREIGN KEY (flightId) REFERENCES Flight(flightId)\r\n"
					+ ")");
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
}
