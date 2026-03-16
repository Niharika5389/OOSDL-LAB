import java.io.RandomAccessFile;
import java.io.IOException;

public class q1 {

    static final int NAME_LENGTH = 20;
    static final int RECORD_SIZE = 4 + (2 * NAME_LENGTH) + 8 + 1;

    static void addRoom(int recordNo, int roomNo, String type, double price, boolean status) {
        try {
            RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");

            raf.seek(recordNo * RECORD_SIZE);

            raf.writeInt(roomNo);

            for (int i = 0; i < NAME_LENGTH; i++) {
                if (i < type.length())
                    raf.writeChar(type.charAt(i));
                else
                    raf.writeChar(' ');
            }

            raf.writeDouble(price);
            raf.writeBoolean(status);

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void displayRoom(int recordNo) {
        try {
            RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");

            raf.seek(recordNo * RECORD_SIZE);

            int roomNo = raf.readInt();

            char[] type = new char[NAME_LENGTH];
            for (int i = 0; i < NAME_LENGTH; i++)
                type[i] = raf.readChar();

            double price = raf.readDouble();
            boolean status = raf.readBoolean();

            System.out.println("Room Number: " + roomNo);
            System.out.println("Room Type: " + new String(type).trim());
            System.out.println("Price: " + price);
            System.out.println("Booked: " + status);

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void bookRoom(int recordNo) {
        try {
            RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");

            raf.seek(recordNo * RECORD_SIZE);

            raf.readInt();

            for (int i = 0; i < NAME_LENGTH; i++)
                raf.readChar();

            raf.readDouble();

            raf.writeBoolean(false);

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void releaseRoom(int recordNo) {
        try {
            RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");

            raf.seek(recordNo * RECORD_SIZE);

            raf.readInt();

            for (int i = 0; i < NAME_LENGTH; i++)
                raf.readChar();

            raf.readDouble();

            raf.writeBoolean(true);

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        addRoom(0, 101, "Deluxe", 2500, true);
        addRoom(1, 102, "Premium", 4000, true);

        displayRoom(0);
        displayRoom(1);

        bookRoom(0);
        releaseRoom(1);

        displayRoom(0);
        displayRoom(1);
    }
}