public class Carrier {
    private int carrierId;
    private String carrierName;
    private int discountPercentageThirtyDaysAdvanceBooking;
    private int discountPercentageSixtyDaysAdvanceBooking;
    private int discountPercentageNinetyDaysAdvanceBooking;
    private int bulkBookingDiscount;
    private int refundPercentageForTicketCancelling2DayBeforeTravelDate;
    private int refundPercentageForTicketCancelling10DayBeforeTravelDate;
    private int refundPercentageForTicketCancelling20DayBeforeTravelDate;
    private int silverUserDiscount;
    private int goldUserDiscount;
    private int platinumUserDiscount;

    public Carrier(int carrierId, String carrierName, int discountPercentageThirtyDaysAdvanceBooking,
            int discountPercentageSixtyDaysAdvanceBooking,
            int discountPercentageNinetyDaysAdvanceBooking,
            int bulkBookingDiscount,
            int refundPercentageForTicketCancelling2DayBeforeTravelDate,
            int refundPercentageForTicketCancelling10DayBeforeTravelDate,
            int refundPercentageForTicketCancelling20DayBeforeTravelDate,
            int silverUserDiscount,
            int goldUserDiscount,
            int platinumUserDiscount) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.discountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
        this.discountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
        this.discountPercentageNinetyDaysAdvanceBooking = discountPercentageNinetyDaysAdvanceBooking;
        this.bulkBookingDiscount = bulkBookingDiscount;
        this.refundPercentageForTicketCancelling2DayBeforeTravelDate = refundPercentageForTicketCancelling2DayBeforeTravelDate;
        this.refundPercentageForTicketCancelling10DayBeforeTravelDate = refundPercentageForTicketCancelling10DayBeforeTravelDate;
        this.refundPercentageForTicketCancelling20DayBeforeTravelDate = refundPercentageForTicketCancelling20DayBeforeTravelDate;
        this.silverUserDiscount = silverUserDiscount;
        this.goldUserDiscount = goldUserDiscount;
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public int getCarrierId() {
        return carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public int getDiscountPercentageThirtyDaysAdvanceBooking() {
        return discountPercentageThirtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageSixtyDaysAdvanceBooking() {
        return discountPercentageSixtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageNinetyDaysAdvanceBooking() {
        return discountPercentageNinetyDaysAdvanceBooking;
    }

    public int getBulkBookingDiscount() {
        return bulkBookingDiscount;
    }

    public int getRefundPercentageForTicketCancelling2DayBeforeTravelDate() {
        return refundPercentageForTicketCancelling2DayBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancelling10DayBeforeTravelDate() {
        return refundPercentageForTicketCancelling10DayBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancelling20DayBeforeTravelDate() {
        return refundPercentageForTicketCancelling20DayBeforeTravelDate;
    }

    public int getSilverUserDiscount() {
        return silverUserDiscount;
    }

    public int getGoldUserDiscount() {
        return goldUserDiscount;
    }

    public int getPlatinumUserDiscount() {
        return platinumUserDiscount;
    }
}
