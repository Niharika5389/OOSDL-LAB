class Hotel {
    private int availableRooms;

    Hotel(int totalRooms) {
        this.availableRooms = totalRooms;
    }

    synchronized void bookRoom(String customerName) {
        while (availableRooms == 0) {
            System.out.println(customerName + " is waiting. No rooms available.");
            try {
                wait(); 
            } catch (InterruptedException e) {
                System.out.println(customerName + " interrupted while waiting");
            }
        }

        availableRooms--;
        System.out.println(customerName + " booked a room. Rooms left: " + availableRooms);
    }

    synchronized void releaseRoom(String customerName) {
        availableRooms++;
        System.out.println(customerName + " released a room. Rooms available: " + availableRooms);
        notify();
    }
}

class Customer extends Thread {
    private Hotel hotel;
    private boolean isBooking;

    Customer(Hotel hotel, String name, boolean isBooking) {
        super(name);
        this.hotel = hotel;
        this.isBooking = isBooking;
    }

    @Override
    public void run() {
        if (isBooking) {
            hotel.bookRoom(Thread.currentThread().getName());
        } else {
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
            hotel.releaseRoom(Thread.currentThread().getName());
        }
    }
}


public class HotelRoomManagement {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(2); 

        Customer c1 = new Customer(hotel, "C1", true);
        Customer c2 = new Customer(hotel, "C2", true);
        Customer c3 = new Customer(hotel, "C3", true);
        Customer c4 = new Customer(hotel, "C1", false); // release thread

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
