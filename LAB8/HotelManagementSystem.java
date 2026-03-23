import java.util.*;

class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }
}

class Customer {
    int customerId;
    String name;
    String contact;
    int roomNumber;

    Customer(int customerId, String name, String contact, int roomNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.roomNumber = roomNumber;
    }
}

public class HotelManagementSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static HashMap<Integer, Customer> roomBookings = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    static void addRoom() {
        try {
            System.out.print("Enter Room Number: ");
            int number = sc.nextInt();

            for (Room r : rooms) {
                if (r.roomNumber == number) {
                    System.out.println("Room already exists!");
                    return;
                }
            }

            System.out.print("Enter Room Type (Single/Double/Deluxe/Suite): ");
            String type = sc.next();

            System.out.print("Enter Price per Day: ");
            double price = sc.nextDouble();

            rooms.add(new Room(number, type, price));
            System.out.println("Room added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }
    static ArrayList<Room> avail = new ArrayList<>();

    static void displayAvailableRooms() {
        
        

        Collections.sort(rooms, Comparator.comparingDouble(r -> r.price));

        System.out.println("\nAvailable Rooms:");
        Iterator<Room> it = rooms.iterator();

        while (it.hasNext()) {
            Room r = it.next();
            if (r.isAvailable) {
                avail.add(r);
                System.out.println("Room No: " + r.roomNumber +
                        " | Type: " + r.roomType +
                        " | Price: " + r.price);
            }
        }
        if (avail.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        
    }

    static void addCustomer() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Contact: ");
            String contact = sc.next();

            customers.add(new Customer(id, name, contact, -1));
            System.out.println("Customer added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    static void bookRoom() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            Customer customer = null;
            for (Customer c : customers) {
                if (c.customerId == id) {
                    customer = c;
                    break;
                }
            }

            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();

            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {

                    if (!r.isAvailable) {
                        System.out.println("Room already booked!");
                        return;
                    }

                    r.isAvailable = false;
                    customer.roomNumber = roomNo;
                    roomBookings.put(roomNo, customer);

                    System.out.println("Room booked successfully!");
                    return;
                }
            }

            System.out.println("Room not found!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    static void checkout() {
        try {
            System.out.print("Enter Room Number for Checkout: ");
            int roomNo = sc.nextInt();

            if (!roomBookings.containsKey(roomNo)) {
                System.out.println("No booking found for this room!");
                return;
            }

            Customer c = roomBookings.get(roomNo);

            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {
                    r.isAvailable = true;
                    break;
                }
            }

            c.roomNumber = -1;
            roomBookings.remove(roomNo);

            System.out.println("Checkout successful!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        Iterator<Customer> it = customers.iterator();

        System.out.println("\nCustomer List:");
        while (it.hasNext()) {
            Customer c = it.next();
            System.out.println("ID: " + c.customerId +
                    " | Name: " + c.name +
                    " | Contact: " + c.contact +
                    " | Room: " + (c.roomNumber == -1 ? "Not Booked" : c.roomNumber));
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Add Customer");
            System.out.println("4. Book Room");
            System.out.println("5. Checkout Customer");
            System.out.println("6. Display All Customers");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    displayAvailableRooms();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    bookRoom();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    displayCustomers();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
