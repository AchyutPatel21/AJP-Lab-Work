import java.net.*;
import java.util.Scanner;

public class StringClientUDP {
    public static void main(String[] args) throws Exception
    {
        System.out.println("\n\t\tAchyut Parsaniya - 92000103081\n");
        DatagramSocket ds = new DatagramSocket(3000);

        Scanner s = new Scanner(System.in);
        String str="";
        do{
            System.out.print("Enter String for sending to Server: ");
            str = s.nextLine();

            InetAddress ip = InetAddress.getByName("localhost");  
            DatagramPacket dp1 = 
                new DatagramPacket(str.getBytes(), str.length(), ip, 3001);  
            ds.send(dp1); 

            DatagramPacket dp2 = new DatagramPacket(new byte[1024], 1024);
            ds.receive(dp2);
            
            String result = new String(dp2.getData(),0,dp2.getLength());
            System.out.println("The String returned from Server is:  "+ result );
        
        }while( !str.equals("stop") );
        s.close();
        ds.close();
    }
}
