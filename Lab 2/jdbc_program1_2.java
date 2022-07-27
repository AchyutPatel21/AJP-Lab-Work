import java.sql.*;

public class jdbc_program1_2 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("\nConnection established");
            stmt = conn.createStatement();
            String sql = "SELECT id, first_name, last_name, salary FROM employee";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int sal = rs.getInt("salary");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                
                System.out.println();
                System.out.print("ID: " + id);
                System.out.print(", Salary: " + sal);
                System.out.print(", First Name: " + first);
                System.out.println(", Last : " + last);
                } 
            stmt.close();
            conn.close();
        }catch (Exception e) {
            System.out.println(e);
      }
    }
}
