import java.io.*;  
import java.net.*;  
import java.util.Scanner;

public class EchoClient {  
public static void main(String[] args) 
{  
    try{      
        Socket s=new Socket("localhost",6666);  
        System.out.println("Client started.");  

        DataOutputStream dout =  new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Massage : ");
        String str = sc.nextLine();
        dout.writeUTF(str);  
        dout.flush();  
        sc.close();

        DataInputStream din = new DataInputStream(s.getInputStream());
        String str1=(String)din.readUTF(); 
        System.out.println("Server : " + str1);
        din.close();
        dout.close();  
        s.close();  
    }
    catch(Exception e){
        System.out.println(e);
    } 
}  
}