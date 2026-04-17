// Abstract Room class
abstract class Room {
    protected int roomNumber;
    protected double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    // Abstract method to be implemented by subclasses
    abstract double calculateTariff();

    // Concrete method
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Total Tariff: $" + calculateTariff());
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

// Interface for Amenities
interface Amenities {
    void provideWifi();
    void provideBreakfast();
}

// StandardRoom class
class StandardRoom extends Room implements Amenities {
    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    double calculateTariff() {
        // Standard room has no additional charges
        return basePrice;
    }

    @Override
    public void provideWifi() {
        System.out.println("Standard Room: Basic WiFi included");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Standard Room: Continental breakfast included");
    }
}

// LuxuryRoom class
class LuxuryRoom extends Room implements Amenities {
    private double luxuryCharge = 0.50; // 50% additional charge

    public LuxuryRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    double calculateTariff() {
        // Luxury room has 50% additional charge
        return basePrice * (1 + luxuryCharge);
    }

    @Override
    public void provideWifi() {
        System.out.println("Luxury Room: High-speed WiFi with premium features included");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Luxury Room: Premium breakfast buffet included");
    }
}

// Main class to demonstrate abstraction and interface-based design
public class HotelRoomManagement {
    public static void main(String[] args) {
        // Create an array of Room references
        Room[] rooms = new Room[2];

        // Instantiate StandardRoom and LuxuryRoom
        rooms[0] = new StandardRoom(101, 100.0);
        rooms[1] = new LuxuryRoom(201, 200.0);

        System.out.println("========== Hotel Room Details ==========");

        // Iterate through rooms and display details
        for (Room room : rooms) {
            room.displayRoomDetails();
            
            // Cast to Amenities interface and display amenities
            if (room instanceof Amenities) {
                Amenities amenities = (Amenities) room;
                amenities.provideWifi();
                amenities.provideBreakfast();
            }
            System.out.println();
        }
    }
}