import java.io.*;
import java.net.*;

public class StringClientTCP {
    
    public static void main(String[] args) throws Exception {
        
        Socket s = new Socket("localhost",9999);
        int stop = 1;
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        String str="",str1="";  
        do
        {
            System.out.print("Enter String for sending to Server: ");
            str = kb.readLine();
            dout.writeBytes(str+"\n");  
            str1 = br.readLine(); 
            System.out.println("\n");
            System.out.println("The String returned from Server is: \n");
            System.out.println(str1 + "\n");
        }while(stop != 1);
        
        dout.close();
        br.close(); 
        kb.close();
        s.close();
    }
}
