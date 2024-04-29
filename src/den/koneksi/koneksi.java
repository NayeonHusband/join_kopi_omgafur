package den.koneksi;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;

public class koneksi {
    
    private static Connection connection;
    
    public static Connection getConnection() {
        if (connection==null) {
            try {
                String url = "jdbc:mysql://localhost:3306/joininkopi1";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    return connection;
    
    }
}
