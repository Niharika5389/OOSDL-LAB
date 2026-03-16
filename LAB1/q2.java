package LAB1;

class Room{
    int roomNo;
    String Type;
    double basePrice;

    Room(int roomNo, String Type, double basePrice){
        this.roomNo = roomNo;
        this.Type = Type;
        this.basePrice = basePrice;
    }

    Room(int roomNo, String Type){
        this.roomNo = roomNo;
        this.Type = Type;
    }

    void display(){
        System.out.println("ROOM DETAILS");
        System.out.println("Room number: "+ roomNo);
        System.out.println("Room Type: "+ Type);
        System.out.println("Room base price: "+ basePrice);
        System.out.println("\n");
    }
}

class DeluxeRoom extends Room{
    String wifiAvail;
    String complimanetaryBreakfast;

    DeluxeRoom(int roomNo, String Type, String wifiAvail, String complimanetaryBreakfast){
        super(roomNo,Type);
        this.wifiAvail = wifiAvail;
        this.complimanetaryBreakfast = complimanetaryBreakfast;
    }

    void display(){
        System.out.println("ROOM DETAILS");
        System.out.println("Room number: "+ roomNo);
        System.out.println("Room Type: "+ Type);
        System.out.println("Room base price: "+ basePrice);
        System.out.println("Room wifi availability: "+ wifiAvail);
        System.out.println("Room complimentary bf: "+ complimanetaryBreakfast);
        System.out.println("\n");
    }
}
public class q2 {
    public static void main(String[] args) {
        Room r1 = new Room(121,"Deluxe");
        Room r2 = new Room(131,"Private", 25000);
        
        DeluxeRoom d = new DeluxeRoom(121,"Deluxe","yes" , "no");

        r1.display();
        r2.display();
        d.display();
    }
}
