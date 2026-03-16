class q3 {
    public static <T extends Number> void total(T price, T discount) {
        double disc = price.doubleValue()*(100-discount.doubleValue())/100;

        System.out.println("Total price: "+ price); 
        System.out.println("Discounted price: "+ disc+"\n"); 
    }
    public static void main(String[] args) {
        total(100, 20);
    }
}