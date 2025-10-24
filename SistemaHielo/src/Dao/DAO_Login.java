package Dao;
import java.sql.*;
import Models.Login;
import Resources.Conexion;


public class DAO_Login {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public Login log(String usuario, String contrasena){
        Login l = new Login();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
    
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                l.setContrasena(rs.getString("contrasena"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setRol(rs.getString("rol"));
            }
        }catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
