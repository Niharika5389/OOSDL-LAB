package LAB1;

class Room{
    int roomNo;
    double baseTariff;

    Room(int roomNo, double baseTariff){
        this.roomNo = roomNo;
        this.baseTariff = baseTariff; 
    }

    double calculateTariff(){
        return baseTariff;
    }
}

class StandardRoom extends Room{

    String aircond;

    StandardRoom(int roomNo, double baseTariff, String aircond){
        super(roomNo, baseTariff);
        this.aircond = aircond;
    }

    @Override
    double calculateTariff(){
        if(aircond=="yes"){
            return (baseTariff + 2500);
        }else{
            return baseTariff;
        }
    }
}
class LuxuryRoom extends Room{

    String aircond;
    int premiumServiceNumber;

    LuxuryRoom(int roomNo, double baseTariff, String aircond, int premiumServiceNumber){
        super(roomNo, baseTariff);
        this.aircond = aircond;
        this.premiumServiceNumber = premiumServiceNumber;
    }

    @Override
    double calculateTariff(){
        if(aircond=="yes"){
            return (baseTariff*premiumServiceNumber + 2500);
        }else{
            return baseTariff*premiumServiceNumber;
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        
        StandardRoom sr = new StandardRoom(121 , 25000, "yes");
        LuxuryRoom lr = new LuxuryRoom(136, 30000, "yes", 4);

        System.out.println("TARIFF DIFFERENCES");
        System.out.println("Standard room:"+sr.calculateTariff());
        System.out.println("Luxury room:"+lr.calculateTariff());

    }
}
