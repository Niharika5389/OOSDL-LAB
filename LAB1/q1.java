package LAB1;

class Book{
    private int ID;
    private String title;
    private String author;
    private double price;
    private String avail_status;

    public void setID(int ID){
        this.ID = ID;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
  
    public void setPrice(double price){
        if(price>=0){
            this.price = price;
        }else{
            System.out.println("Invalid price value.....must be positive");
        }
    }
    public void setStaus(String avail_status){
        this.avail_status = avail_status;
    }


    public int getID(){
        return ID;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public String getStatus(){
        return avail_status;
    }
}

public class q1 {
    public static void main(String[] args) {
        Book b = new Book();

        b.setID(1);
        b.setTitle("Maze Runner");
        b.setAuthor("Someone");
        b.setPrice(499);
        b.setStaus("available");


        System.out.println("BOOK DETAILS");
        System.out.println("Book ID:"+b.getID());
        System.out.println("Book Title:"+b.getTitle());
        System.out.println("Book Author:"+b.getAuthor());
        System.out.println("Book Price:"+b.getPrice());
        System.out.println("Book availability:"+b.getStatus());

    }
}
