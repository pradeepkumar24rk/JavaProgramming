import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Admin extends AMS {

  public static void createCarrier() {
    if (carrierCount >= 10) {
      System.out.println("Carrier list is full. Cannot add more carriers.");
      return;
    }

    System.out.print("Enter the Carrier Name: ");
    String carrierName = sc.nextLine().trim();

    System.out.print("Enter Discount for 30 Days Advance Booking: ");
    int discount30Days = sc.nextInt();

    System.out.print("Enter Discount for 60 Days Advance Booking: ");
    int discount60Days = sc.nextInt();

    System.out.print("Enter Discount for 90 Days Advance Booking: ");
    int discount90Days = sc.nextInt();

    System.out.print("Enter Bulk Booking Discount: ");
    int bulkBooking = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (2 Days Before): ");
    int refund2Days = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (10 Days Before): ");
    int refund10Days = sc.nextInt();

    System.out.print("Enter Refund for Ticket Cancellation (20 Days Before): ");
    int refund20Days = sc.nextInt();

    System.out.print("Enter Silver User Discount: ");
    int silverDiscount = sc.nextInt();

    System.out.print("Enter Gold User Discount: ");
    int goldDiscount = sc.nextInt();

    System.out.print("Enter Platinum User Discount: ");
    int platinumDiscount = sc.nextInt();

    Carrier newCarrier = new Carrier(carrierCount + 1, carrierName, discount30Days, discount60Days, discount90Days,
        bulkBooking, refund2Days, refund10Days, refund20Days, silverDiscount, goldDiscount, platinumDiscount);
    carrierList[carrierCount++] = newCarrier;
    System.out.println("Carrier Added Successfully");
  }

  public static void editCarrier() {
    System.out.print("Enter Carrier ID: ");
    int carrierId = sc.nextInt();
    sc.nextLine();

    if (carrierId < 1 || carrierId > carrierList.length || carrierList[carrierId - 1] == null) {
      System.out.println("Invalid Carrier ID.");
      return;
    }

    System.out.print("Enter new Carrier Name: ");
    String carrierName = sc.nextLine();

    System.out.print("Enter new Discount for 30 Days Advance Booking: ");
    int discount30Days = sc.nextInt();

    System.out.print("Enter new Discount for 60 Days Advance Booking: ");
    int discount60Days = sc.nextInt();

    System.out.print("Enter new Discount for 90 Days Advance Booking: ");
    int discount90Days = sc.nextInt();

    System.out.print("Enter new Bulk Booking Discount: ");
    int bulkBooking = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (2 Days Before): ");
    int refund2Days = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (10 Days Before): ");
    int refund10Days = sc.nextInt();

    System.out.print("Enter new Refund for Ticket Cancellation (20 Days Before): ");
    int refund20Days = sc.nextInt();

    System.out.print("Enter new Silver User Discount: ");
    int silverDiscount = sc.nextInt();

    System.out.print("Enter new Gold User Discount: ");
    int goldDiscount = sc.nextInt();

    System.out.print("Enter new Platinum User Discount: ");
    int platinumDiscount = sc.nextInt();

    carrierList[carrierId - 1] = new Carrier(carrierId, carrierName, discount30Days, discount60Days, discount90Days,
        bulkBooking, refund2Days, refund10Days, refund20Days, silverDiscount, goldDiscount, platinumDiscount);
    System.out.println("Carrier Updated Successfully");
  }

  public static void deleteCarrier() {
    System.out.print("Enter Carrier ID: ");
    int carrierId = sc.nextInt();
    sc.nextLine();

    if (carrierId < 1 || carrierId > carrierList.length || carrierList[carrierId - 1] == null) {
      System.out.println("Invalid Carrier ID.");
      return;
    }

    for (Flight flight : flightList) {
      if (flight != null && flight.getCarrierId() == carrierId) {
        System.out.println("Remove all flights associated with this carrier before deleting.");
        return;
      }
    }

    carrierList[carrierId - 1] = null;
    System.out.println("Carrier removed successfully.");
  }

  public static void createFlight() {
    if (flightCount >= 10) {
      System.out.println("Flight list is full. Cannot add more flights.");
      return;
    }

    System.out.print("Enter CarrierId: ");
    int carrierId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Origin: ");
    String origin = sc.nextLine();

    System.out.print("Enter Destination: ");
    String destination = sc.nextLine();

    System.out.print("Enter Air Fare: ");
    int airfare = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Economy Class: ");
    int seatCapacityEconomyClass = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Business Class: ");
    int seatCapacityBusinessClass = sc.nextInt();
    
    System.out.print("Enter Seat Capacity Executive Class: ");
    int seatCapacityExecutiveClass = sc.nextInt();

    Flight newFlight = new Flight(flightCount + 1, carrierId, origin, destination, airfare,
        seatCapacityEconomyClass, seatCapacityBusinessClass, seatCapacityExecutiveClass);
    flightList[flightCount++] = newFlight;
    System.out.println("Flight Added Successfully");
  }

  public static void sheduleFlight() {
    System.out.print("Enter FlightId: ");
    int flightId = sc.nextInt();

    sc.nextLine();
    System.out.print("Enter Date of Travel: ");
    String dateOfTravel = sc.nextLine();

    Flight f = flightList[flightId - 1];

    if (f == null) {
      System.out.println("Flight is Not Available");
      return;
    }

    FlightSchedule newScheduleFlight = new FlightSchedule(flightScheduleCount + 1, flightId, dateOfTravel);
    flightScheduleList[flightScheduleCount++] = newScheduleFlight;
    System.out.println("Flight " + flightId + " is scheduled");
  }

  public static void fightCancellation() {
    System.out.print("Enter Flight Id: ");
    int flightId = sc.nextInt();
    
    sc.nextLine();
    System.out.print("Enter Date of travel: ");
    String travelDate = sc.nextLine();

    int totalRefundAmount = 0;
    for (int i = 0; i < flightBookingCount; i++) {
      FlightBooking temp = flightBookingList[i];
      if (temp.getFlightId() == flightId && temp.getDateOfTravel().equals(travelDate)) {
        temp.setBookingStatus("Cancelled");
        totalRefundAmount += temp.getBookingAmount();
      }
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate currentDate = LocalDate.now();
    LocalDate dateOfTravel = LocalDate.parse(travelDate, formatter);

    long daysBetween = ChronoUnit.DAYS.between(currentDate, dateOfTravel);

    if (daysBetween > 7)
      System.out.println("Refund Account For All Flight Cancellation: Rs. " + totalRefundAmount);
    else
      System.out.println("Refund Account For All Flight Cancellation Within One week: Rs. "
          + (totalRefundAmount + (totalRefundAmount * 10) / 100));
  }

  public static void displayCarrier() {
    if (carrierCount == 0) {
      System.out.println("\nNo Carriers Registered Yet.");
    } else {
      System.out.println("\nList of Carriers:");
      for (int i = 0; i < carrierCount; i++) {
        Carrier carrier = carrierList[i];
        if (carrier != null)
          System.out.println("Carrier ID: " + carrier.getCarrierId() + " | Name: " + carrier.getCarrierName());
      }
    }
  }

  public static void displayFlight() {
    if (flightCount == 0) {
      System.out.println("\nNo Flights Registered Yet.");
    } else {
      System.out.println("\nList of Flights:");
      for (int i = 0; i < flightCount; i++) {
        Flight flight = flightList[i];
        if (flight != null)
          System.out.println("Flight ID: " + flight.getFlightId() + " | Carrier ID: " + flight.getCarrierId());
      }
    }
  }

  public static void displayFlightBookedDetails() {
    if (flightBookingCount > 0) {
      for (int i = 0; i < flightBookingCount; i++) {
        System.out.println("Booking Id: " + flightBookingList[i].getBookingId() +
            "| Flight Id: " + flightBookingList[i].getFlightId() +
            "| User Id: " + flightBookingList[i].getUserId() +
            "| No Of Seats: " + flightBookingList[i].getNoOfSeats() +
            "| Booking Status: " + flightBookingList[i].getBookingStatus() +
            "| Booking Amount: " + flightBookingList[i].getBookingAmount());
      }
    } else
      System.out.println("Empty Booking Details.");
  }

  public static boolean adminMenu() {
    int choose_menu = 0;
    do {
      System.out.print("-------------------------------------------------------------------");
      System.out.print(
          "\nAdmin Menu\n1.Add Carrier\n2.Edit Carrier Details by CarrierId\n3.Remove Carrier by Id\n4.Flight Cancellation - Refund Price Calculation\n5.Add Flight\n6.Schedule Flight\n7.Display Carrier\n8.Display Flight\n9.Display All Flight Booking Details\n10.Exit Admin\n11.Exit AMS");
      System.out.print("\n-------------------------------------------------------------------");
      System.out.print("\nEnter the operation : ");
      choose_menu = sc.nextInt();
      sc.nextLine();
      switch (choose_menu) {
        case 1:
          System.out.println("Add Carrier");
          createCarrier();
          break;
        case 2:
          System.out.println("Edit Carrier Details by CarrierId");
          editCarrier();
          break;
        case 3:
          System.out.println("Remove Carrier by Id");
          deleteCarrier();
          break;
        case 4:
          System.out.println("Flight Cancellation - Refund Price Calculation");
          fightCancellation();
          break;
        case 5:
          System.out.println("Add Flight");
          createFlight();
          break;
        case 6:
            System.out.println("Schedule Flight");
            sheduleFlight();
            break;
        case 7:
          System.out.println("Display Carriers");
          displayCarrier();
          break;
        case 8:
          System.out.println("Display Flights");
          displayFlight();
          break;
        case 9:
            System.out.println("Display Flight Booking Details");
            displayFlightBookedDetails();
            break;
        case 10:
          System.out.println("Exit Admin");
          break;
        case 11:
          System.out.println("Exit AMS");
          return true;
        default:
          System.out.print("Invalid");
      }
    } while (choose_menu != 10);
    return false;
  }
}