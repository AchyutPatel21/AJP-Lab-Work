import java.io.*;
import java.net.*;
import java.util.Scanner;
class FileClient
{
    public static void main(String args[ ]) throws Exception
    {
        System.out.println("\n\t\tAchyut Parsaniya - 92000103081\n");
        Socket s = new Socket("localhost", 8888);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter filename: ");
        String fname = kb.readLine();

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader  in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter New File Name : ");
        String NewFileName = sc.nextLine();
        FileWriter fr = new FileWriter(new File(NewFileName));
        sc.close();

        out.writeBytes(fname+"\n");

        String str;
        str = in.readLine();
        if(str.equals("Yes"))
        {
            System.out.println("Displaying the File content sent by Server.");
            while((str = in.readLine()) != null) {
                System.out.println(str);
                fr.append(str);
                fr.flush();
            }
            kb.close();
            out.close();
            in.close();
            s.close();
            fr.close();
        }
        else
            System.out.println("File not found");
    }
}
