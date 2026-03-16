class OnlineOrder implements Runnable{
    private String task;

    OnlineOrder(String task){
        this.task = task;
    }

    @Override
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println(task+" for customer "+(i+1));
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

public class q2{
    public static void main(String[] args) {
        
        OnlineOrder task1 = new OnlineOrder("Order Validated");
        OnlineOrder task2 = new OnlineOrder("Payment processed");
        OnlineOrder task3 = new OnlineOrder("Order Shipped");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        t2.start();
        try{
            t2.join();
        }catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        t3.start();
        try{
            t3.join();
        }catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        
        System.out.println("Main thread completed");
    }
}
