import java.io.*;
import java.net.*;

public class FileServer  {

    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        System.out.println("Connection established");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String fname = in.readLine();
        FileReader fr = null;
        BufferedReader file = null;
        boolean flag;
        
        File f = new File(fname);
        
        if(f.exists()) 
            flag = true;
        else 
            flag = false;
        
        if(flag == true) 
            out.writeBytes("Yes"+"\n");
        else 
            out.writeBytes("No"+"\n");
        if(flag == true)
        {
            fr = new FileReader(fname);
            file = new BufferedReader(fr);
            String str;
            while((str = file.readLine()) != null)
            {
                out.writeBytes(str+"\n");
            }
            file.close(); 
            out.close();
            in.close();
            fr.close();
            s.close();
            ss.close();
        }   

    }
    
}
