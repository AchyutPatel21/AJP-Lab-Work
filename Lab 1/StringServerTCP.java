import java.io.*;
import java.net.*;

public class StringServerTCP {

    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Waiting Client to connect...");
        Socket s = ss.accept();
        System.out.println("Connection Established...");

        PrintStream p = new PrintStream(s.getOutputStream());   
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while(true) {   
            String str,str1;  
            while((str = br.readLine()) != null)  {   
                System.out.println("\n Count Of Characters & Digits In String Displayed ");   
                int countCha = 0,countNum = 0,specialCha =0;  
                for(int i=0;i<str.length();i++)
                {
                    if(str.charAt(i)>='0' && str.charAt(i)<='9')
                        countNum++;
                    else if( (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                        (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) == ' ') )
                        countCha++;
                    else
                        specialCha++;
                }
                str1 = " Total Number Of Characters = " + countCha;
                    str1 += " Total Number Of Digits = " + countNum;  
                        str1 += " Total Number Of Special Characters = " + specialCha;
                p.println(str1); 
            }       
            ss.close();
            s.close(); 
        }  

    }

}