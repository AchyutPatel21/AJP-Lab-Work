import java.io.*; 
import java.net.*; 

public class  TWCServer  { 
    public static void main(String args[])throws Exception
    {  
        ServerSocket ss=new ServerSocket(3333);  
        System.out.println("Server started.");
        System.out.println("Waiting for Client to connect.");  
        Socket s=ss.accept();  
        System.out.println("Connection Established...");
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        String str1="",str2="";  
        while(!str1.equals("stop"))
        {  
                System.out.println("Waiting for Client's messsage...");  
                str1=din.readUTF();  
                System.out.println("Client: "+str1);  
                System.out.print("Enter your message here: ");  
                str2=br.readLine();  
                dout.writeUTF(str2);  
                dout.flush();  
        }  
        din.close();  
        s.close();  
        ss.close();  
    }
}
