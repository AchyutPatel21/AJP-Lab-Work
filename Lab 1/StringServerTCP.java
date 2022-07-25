import java.io.*;
import java.net.*;

public class StringServerTCP {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\t\tAchyut Parsaniya - 92000103081\n");
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Waiting Client to connect...");
        Socket s = ss.accept();
        System.out.println("Connection Established...");
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        String str,str1;  
        do
        {   
            System.out.println("Waiting for Client to send a String.");
            str = br.readLine();
            int countCha = 0,countNum = 0,specialCha =0;  
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)>='0' && str.charAt(i)<='9')
                    countNum++;
                else if( (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                    (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) == ' ') )
                    countCha++;
                else if (str.charAt(i) == '!' || str.charAt(i) == '@' || str.charAt(i) == '#' || str.charAt(i) == '$' || 
                str.charAt(i) == '%' || str.charAt(i) == '^' || str.charAt(i) == '&' || str.charAt(i) == '*' || 
                str.charAt(i) == '_' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '?' || 
                str.charAt(i) == ':' || str.charAt(i) == '`' || str.charAt(i) == '~')
                    specialCha++;
            }
            str1 = "\nTotal Number Of Characters = " + countCha + 
            "\nTotal Number Of Digits = " + countNum +
            "\nTotal Number Of Special Characters = " + specialCha;

            dout.writeUTF(str1);
            dout.flush();
            System.out.println("Count of Characters & Digits in the String sent to Client.");

        } while( !str.equals("stop") );
      
        ss.close();
        s.close();  
    } 

}
