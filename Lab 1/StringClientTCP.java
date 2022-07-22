import java.io.*;
import java.net.*;

public class StringClientTCP {
    
    public static void main(String[] args) throws Exception {
        
        Socket s = new Socket("localhost",9999);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());
        BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        String str="",str1="";  
        do
        {
            System.out.print("\nEnter String for sending to Server: ");
            str = kb.readLine();
            dout.writeBytes(str+"\n");  
            str1 = din.readUTF(); 
            System.out.println("The String returned from Server is: ");
            System.out.println(str1);

        }while(!str.equals("stop"));

        dout.close();
        din.close();
        br.close(); 
        kb.close();
        s.close();
    }
}
