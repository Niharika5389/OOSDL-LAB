class HotelRoomServiceThread extends Thread{
    private String task;

    HotelRoomServiceThread(String task){
        this.task = task;
    }

    @Override
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println(task+" for room "+(i+1));
            Thread.yield();

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(task+" interrupted");
            }
            
        }
         System.out.println(task+" completed");
    }
}

public class q1{
    public static void main(String[] args) {
        
        HotelRoomServiceThread t1 = new HotelRoomServiceThread("Room Cleaned");
        HotelRoomServiceThread t2 = new HotelRoomServiceThread("Food Delivered");
        HotelRoomServiceThread t3 = new HotelRoomServiceThread("Maintainance done");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main thread completed");
    }
}
