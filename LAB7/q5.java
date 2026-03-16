class Pair<T, U> {
    private T RoomNo;
    private U GuestName;

    public Pair(T RoomNo, U GuestName) {
        this.RoomNo = RoomNo;
        this.GuestName = GuestName;
    }
    public T getRoomNo() {
        return RoomNo;
    }
    public U getGuestName() {
    return GuestName;
    }
    public void display() {
        System.out.println("RoomNo : " + RoomNo);
        System.out.println("GuestName : " + GuestName);
        System.out.println("\n");
    }
}
public class q5 {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(101, "Neha");
        p1.display();
        Pair<Integer, String> p2 = new Pair<>(105, "Viha");
        p2.display();
    }
}