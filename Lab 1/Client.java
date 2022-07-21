import java.io.*;  
import java.net.*;  
public class Client {  
    public static void main(String[] args) {  
        try{      
            Socket s=new Socket("localhost",6666);
            System.out.println("Client started.");
            System.out.println("Waiting for Server...");  
            DataOutputStream dout =  new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server");  
            dout.flush();  
            dout.close();  
            s.close();  
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }  
}
