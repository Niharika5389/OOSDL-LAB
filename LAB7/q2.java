public class q2 {

    public static <T> void display(T value){
        System.out.println(value);
    }
    public static void main(String[] args) {
        System.out.println("Room details");
        display(101);
        display("Deluxe");
        display(4500.0);
        display( true);
    }
}