
package practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Practice {

    // JDBC URL
    static final String URL = "jdbc:mysql://localhost:3306/student";
    static final String USER = "root";
    static final String PASSWORD = "Tanu@2906";

    public static void main(String[] args) {

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create statement
            Statement st = conn.createStatement();

            
////            insert new data
            int affected=st.executeUpdate("insert into data(id,name,email,status,age)"+ "values(1,'Rohit','efrjgh@gmail.com',2,34)");
            System.out.println("Insert done"+" "+affected);
            
            
//            update data
            int a3=st.executeUpdate("update data set age=23 where name='Rohit'");
            System.out.println("data updated");
            
            
//          delete all data
          int a2=st.executeUpdate("delete from data");
          System.out.println("data deleted");
          
            
            // Execute query
            ResultSet rs = st.executeQuery("SELECT * FROM data");

            // Process result
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Close resources
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



