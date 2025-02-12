import java.util.*;

public class Admin extends AMS {
  static Scanner sc = new Scanner(System.in);

  public static void createCarrier() {
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
    try {
      int carrierId = carrierMapList.size() + 1;

      Carrier newCarrier = new Carrier(carrierId, carrierName, discount30Days, discount60Days, discount90Days,
          bulkBooking,
          refund2Days, refund10Days, refund20Days, silverDiscount, goldDiscount, platinumDiscount);
      carrierMapList.put(carrierId, newCarrier);
      System.out.println("Carrier Added Successfully");
    } catch (Exception e) {
      System.out.println("Encountered issue while saving carrier information. Please check the data and try again");
    }
  }

  public static void editCarrier() {
    System.out.print("Enter Carrier ID: ");
    int carrierId = sc.nextInt();
    sc.nextLine();
    
    if (!carrierMapList.containsKey(carrierId))
      System.out
          .println("Either the data is incorrect or no Carrier informationis availabe for tha given Ca  rrier ID ");

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
    try {
      Carrier newCarrier = new Carrier(carrierId, carrierName, discount30Days, discount60Days, discount90Days,
          bulkBooking,
          refund2Days, refund10Days, refund20Days, silverDiscount, goldDiscount, platinumDiscount);
      carrierMapList.put(carrierId, newCarrier);
      System.out.println("Carrier Added Successfully");
    } catch (Exception e) {
      System.out.println("Encountered issue while saving carrier information. Please check the data and try again");
    }
  }

  public static void displayCarrier() {
    if (carrierMapList.isEmpty()) {
      System.out.println("\nNo Customers Registered Yet.");
  } else {
      System.out.println("\nList of Customers:");
      for (Map.Entry<Integer, Carrier> map : carrierMapList.entrySet()) {
          System.out.println(
                  "Carrier ID: " + map.getValue().getCarrierId() +
                  " | Name: " + map.getValue().getCarrierName()
          );
      }
  }
  }

  public static boolean adminMenu() {
    int choose_menu = 0;
    do {
      System.out.print("-------------------------------------------------------------------");
      System.out.print(
          "\nAdmin Menu\n1.Add Carrier\n2.Edit Carrier Details by CarrierId\n3.Remove Carrier by Id\n4.Flight Cancellation - Refund Price Calculation\n5.Exit Admin\n6.Exit AMS");
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
          break;
        case 4:
          System.out.println("Flight Cancellation - Refund Price Calculation");
          displayCarrier();
          break;
        case 5:
          System.out.println("Exit Admin");
          break;
        case 6:
          System.out.println("Exit AMS");
          return true;
        default:
          System.out.print("Invalid");
      }
    } while (choose_menu != 5);
    return false;
  }
}