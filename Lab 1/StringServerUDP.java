import java.net.*;

public class StringServerUDP {
    
    public static void main(String[] args) 
    {
        try {

            DatagramSocket ds = new DatagramSocket(3001);
            byte [] buf = new byte[100];
            DatagramPacket dp = new DatagramPacket(buf, 100);

            System.out.println("Waiting for Client to send a String.");
            ds.receive(dp);

            String str = new String(dp.getData(), 0, dp.getLength());

            int charCount =0, digitCount = 0, specialCount =0;
            for(int i =0;i<str.length();i++)    
            {

                if(str.charAt(i)>='0' && str.charAt(i)<='9')
                        digitCount++;
                
                    else if( (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                        (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) == ' ') )
                            charCount++;
                
                    else if (str.charAt(i) == '!' || str.charAt(i) == '@' || str.charAt(i) == '#' || str.charAt(i) == '$' || 
                        str.charAt(i) == '%' || str.charAt(i) == '^' || str.charAt(i) == '&' || str.charAt(i) == '*' || 
                        str.charAt(i) == '_' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '?' || 
                        str.charAt(i) == ':' || str.charAt(i) == '`' || str.charAt(i) == '~')
                            specialCount++;    
            }

            String result = "\nCharacters Count : "+ charCount + 
                            "\nDigits Count : "+ digitCount + 
                            "\nSpecial Characters Count : "+ specialCount;
            System.out.println(result);
            
            DatagramPacket dp1 = 
            new DatagramPacket(result.getBytes(), result.length(),InetAddress.getByName("localhost"),3000);
            ds.send(dp1);
            
            System.out.println("RB "+result.getBytes());
            System.out.println(InetAddress.getByName("localhost"));
            System.out.println(dp1.getPort());
            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
