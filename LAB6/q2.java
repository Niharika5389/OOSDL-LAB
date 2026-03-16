import java.io.*;
import java.util.ArrayList;

class Room implements Serializable {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean bookingStatus;
    String guestName;

    Room(int rn, String rt, double price, boolean booked, String guest) {
        roomNumber = rn;
        roomType = rt;
        pricePerNight = price;
        bookingStatus = booked;
        guestName = guest;
    }

    public String toString() {
        return "Room: " + roomNumber + "\nType: " + roomType + "\nPrice: " + pricePerNight +
               "\nBooked: " + bookingStatus + "\nGuest: " + guestName + "\n----------------";
    }
}

public class q2 {

    public static void main(String[] args) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rooms.dat"));
            oos.writeObject(new Room(101, "Deluxe", 2500, false, ""));
            oos.writeObject(new Room(102, "Premium", 4000, false, ""));
            oos.close();

            System.out.println("All rooms:");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rooms.dat"));
            while (true) {
                try {
                    Room r = (Room) ois.readObject();
                    System.out.println(r);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();

            // Read all rooms into list
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("rooms.dat"));
            ArrayList<Room> roomList = new ArrayList<>();

            while (true) {
                try {
                    Room r = (Room) ois2.readObject();
                    if (r.roomNumber == 101) {
                        r.bookingStatus = true;
                        r.guestName = "John";
                    }
                    roomList.add(r);
                } catch (EOFException e) {
                    break;
                }
            }
            ois2.close();
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("rooms.dat"));
            for (Room r : roomList) {
                oos2.writeObject(r);
            }       
            oos2.close();

            System.out.println("After booking room 101:");
            ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("rooms.dat"));
            while (true) {
                try {
                    Room r = (Room) ois3.readObject();
                    System.out.println(r);
                } catch (EOFException e) {
                    break;
                }
            }
            ois3.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}