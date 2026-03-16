import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class q1 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try{
            fis = new FileInputStream("q1_old.txt");
            fos = new FileOutputStream("q1_new.txt");
            int data;
            while((data = fis.read())!=-1){
                fos.write(data);
            }
            System.out.println("Data written succesfully");

        }catch(IOException e){
            System.out.println("File error: "+e.getMessage());

        }finally{
            try{
                if(fos!=null){
                    fos.close();
                }
                if(fis!=null){
                    fis.close();
                }
                
            }catch(IOException e){
                System.out.println("Error closing file");
            }
        }
    }
}
