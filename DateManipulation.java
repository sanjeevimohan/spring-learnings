import java.util.Date;

class DateManipulation {
    public static void main(String[] args) {
        
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
         System.out.println(now.getTime()/1000);
    }
}