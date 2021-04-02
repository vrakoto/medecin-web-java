package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    private static Connection con;
    public static Connection get()  {
        if (con == null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e ){
                System.out.println("Pilote mal installé ..."+e);
            }
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost/medecin", "sio", "linux");
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    public static void close()  {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}