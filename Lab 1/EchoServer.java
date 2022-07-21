import java.io.*; 
import java.net.*; 

public class EchoServer {
    public static void main(String[] args){ 
        try{ 
            ServerSocket ss=new ServerSocket(6666); 
            System.out.println("Server started."); 
            Socket s=ss.accept(); 
            DataInputStream din = new DataInputStream(s.getInputStream()); 
            String str=(String)din.readUTF(); 
            System.out.println("Client : "+str); 

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(str);
            dout.flush();
            dout.close();
            din.close();
            s.close();
            ss.close(); 
        }
        catch(Exception e){
            System.out.println(e);
        } 
    } 
}
