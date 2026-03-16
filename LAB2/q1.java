public class q1 {

    public static void main(String[] args) {

        double roomTariff = 1500.0;
        int days = 3;
        double serviceCharges = 500.0;

        Double roomTariffObj = roomTariff;
        Integer daysObj = days;
        Double serviceChargesObj = serviceCharges;

        double totalRoomCharge = roomTariffObj * daysObj;
        double totalBill = totalRoomCharge + serviceChargesObj;

        System.out.println("Hotel Bill Details");
        System.out.println("Room Tariff per Day: " + roomTariffObj);
        System.out.println("Number of Days: " + daysObj);
        System.out.println("Service Charges: " + serviceChargesObj);
        System.out.println("Total Bill Amount: " + totalBill);
    }
}
