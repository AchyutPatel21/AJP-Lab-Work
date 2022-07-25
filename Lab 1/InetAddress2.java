import java.net.*;
import java.util.Scanner;

public class InetAddress2 {
    public static void main(String args[]) throws UnknownHostException {
        
        System.out.println("\n\t\tAchyut Parsaniya - 92000103081\n");
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println("Local Host : "+Address);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Domain Name : ");
        String website = sc.nextLine();
        Address = InetAddress.getByName(website);
        System.out.println("Website "  + Address);

        System.out.println("Enter Domain Name : ");
        String website2 = sc.nextLine();
        InetAddress SW[] = InetAddress.getAllByName(website2);
        for (int i=0; i<SW.length; i++)
            System.out.println(SW[i]);

        sc.close();    
    }
}
