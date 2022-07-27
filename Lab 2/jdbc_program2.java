import java.sql.*;
import java.util.Scanner;

public class jdbc_program2{

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "root";
    static final String PASS = ""; 

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("\nConnection Established\n");
            stmt = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            int ch ;
            System.out.println("1. To Display Data");
            System.out.println("2. To Insert Data");
            System.out.println("3. To Update Data");
            System.out.println("4. To Delete Data");
            System.out.println("\nEnter Your Choice : ");
            ch = sc.nextInt();

            switch(ch) {

                case 1 :

                    rs = stmt.executeQuery("select * from emp"); 

                    System.out.println("\nDisplay Data : ");
                    while(rs.next())  
                        System.out.println(rs.getInt(1)+"  "+rs.getString(2) +"  "+rs.getInt(3)+"  "+rs.getString(4));
                    break;
                
                case 2 :

                    int id ,age;
                    String name="",city="";

                    System.out.println("Enter Data : ");
                    System.out.println("ID : ");
                    id = sc.nextInt();
                    System.out.println("NAME : ");
                    name = sc.next();
                    System.out.println("AGE : ");
                    age = sc.nextInt();
                    System.out.println("CITY : ");
                    city = sc.next();

                    int i1 = stmt.executeUpdate("INSERT into emp values("+id+", '"+name+"', "+age+", '"+city+"')");
                    if(i1==0)
                        System.out.println("Data not inserted.");
                    else
                        System.out.println("Data inserted.");   
                    
                    break;
                 
                case 3 :

                    String uname;
                    int uid;
                    System.out.println("Enter Updated Name : ");
                    uname = sc.next();
                    System.out.println("Which ID you want to update :");
                    uid = sc.nextInt();


                    int u1 = stmt.executeUpdate("UPDATE emp set NAME = '"+uname+"' where ID = "+uid+" ");
                    if(u1==0)
                        System.out.println("Data not updated.");
                    else
                        System.out.println("Data updated.");   
                    
                    break;
                
                case 4 :

                    int did;
                    System.out.println("Enter ID which you want to delete : ");
                    did = sc.nextInt();

                    int d1 = stmt.executeUpdate("DELETE from emp where ID = "+did+" ");
                    if(d1==0)
                        System.out.println("Data not deleted.");
                    else
                        System.out.println("Data deleted.");   
                    
                    break;    
                
                default :
                    System.out.println("Enter Valid Choice...!!");    
            }


            sc.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}