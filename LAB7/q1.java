class Room<T, U> {
    private T first;
    private U second;

    public Room(T first, U second) {
        this.first = first;                                                                                                                                                                                                                                                                            
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }
    public void display() {
        System.out.println("First Value: " + first);
        System.out.println("Second Value: " + second);
        System.out.println("\n");
    }
}
public class q1 {
    public static void main(String[] args) {
        Room<Integer, String> p1 = new Room<>(101, "Deluxe");
        p1.display();
        Room<String, Double> p2 = new Room<>("Room Price", 3500.50);
        p2.display();
    }
}