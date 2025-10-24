package Dao;
import java.sql.*;
import java.util.*;
import Models.Usuarios;
import Resources.Conexion;

public class DAO_Usuarios {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    //REGISTRAR UN NUEVO USUARIO
    public boolean registrarUsuario(Usuarios u) {
        String sql = "INSERT INTO usuarios (usuario, contrasena, nombre, correo, rol) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContrasena());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getRol());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar al usuario: " + e.getMessage());
            return false;
        }
    }
    
    //LISTAR A LOS USUARIOS EN LA TABLA
    public List<Usuarios> listarUsuarios() {
        List<Usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar a los usuarios: " + e.getMessage());
        }
        return lista;
    }
    
}
