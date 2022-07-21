import java.io.*;  
import java.net.*;  

public class TWCClient {  
    public static void main(String args[])throws Exception {  
        
        Socket s=new Socket("localhost",3333);  
        System.out.println("Client started.");  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String str="",str2="";  
        while(!str.equals("stop"))
        {
            System.out.print("Enter your message here: ");  
            str=br.readLine();  
            dout.writeUTF(str);  
            dout.flush();  
            System.out.println("Waiting for Server's messsage...");  
            str2=din.readUTF();  
            System.out.println("Server: "+str2);  
        }   
        dout.close();  
        s.close();  
    }  
}
