import java.sql.*; 
class MysqlStatement2{ 
    public static void main(String args[]){ 
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con =  
            DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb","root", ""); 
            System.out.println("\nConnection established");
            Statement stmt=con.createStatement(); 
            int result = stmt.executeUpdate("delete from emp where id=1"); 
            System.out.println(result+" records affected"); 
            con.close(); 
        }catch(Exception e){ System.out.println(e);} 
    } 
}
