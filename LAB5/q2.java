import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class q2 {
    public static void main(String[] args) {
        
        try{
            FileReader fr = new FileReader("q2_old.txt");
            FileWriter fw = new FileWriter("q2_new.txt");
            int ch;
            while((ch = fr.read())!=-1){
                fw.write(ch);
            }
            fr.close();
            fw.close();
            System.out.println("Data written succesfully");
        }catch(IOException e){
            System.out.println("File error: "+e.getMessage());
        }
    }
}
