import java.net.*;
import java.util.Scanner;

public class URL2 {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        System.out.println("\n\t\tAchyut Parsaniya - 92000103081\n");
        System.out.println("Enter URL : ");
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        URL hp = new URL(url);
        System.out.println("\nProtocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());

        sc.close();
    }
}
