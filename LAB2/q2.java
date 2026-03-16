
enum RoomType {

    STANDARD(1000),
    DELUXE(2000),
    SUITE(3500);

    private int baseTariff;

    RoomType(int baseTariff) {
        this.baseTariff = baseTariff;
    }

    public int getBaseTariff() {
        return baseTariff;
    }

    public int calculateTotalCost(int days) {
        return baseTariff * days;
    }
}

public class q2 {

    public static void main(String[] args) {

        RoomType room = RoomType.DELUXE;

        int days = 3;

        int totalCost = room.calculateTotalCost(days);

        System.out.println("Room Type: " + room);
        System.out.println("Base Tariff per Day: " + room.getBaseTariff());
        System.out.println("Number of Days: " + days);
        System.out.println("Total Room Cost: " + totalCost);
    }
}
