package Resources;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
     
    Connection con;

    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistemahielo?useSSL=false&serverTimezone=America/Lima";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return con;
    }
}