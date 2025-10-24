package Dao;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import Resources.Conexion;
import Models.Clientes;

public class DAO_Clientes {
    //CONEXION A LA BASE DE DATOS
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //REGISTRAR A LOS NUEVOS USUARIOS
    public boolean RegistrarClientes(Clientes cl) {
        String sql = "INSERT INTO clientes (documento, nombre, celular, direccion, correo, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDocumento());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getCelular());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCorreo());
            ps.setString(6, cl.getEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiOn: " + e.toString());
            }
        }
    }
    //ELIMINA LOS CLIENTES REGISTRADOS
    public boolean EliminarClientes(int id){
         String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    //MODIFICAR CLIENTES REGISTRADOS
    public boolean ModificarClientes(Clientes cl){
        String sql = "UPDATE clientes SET documento=?, nombre=?, celular=?, direccion=?, correo=?, estado=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDocumento());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getCelular());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCorreo());
            ps.setString(6, cl.getEstado());
            ps.setInt(7, cl.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }
    // LISTAR LOS CLIENTES EN EL CUADRO
    public List<Clientes> ListarClientes() {
        List<Clientes> ListaCli = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cl = new Clientes();
                cl.setId(rs.getInt("id"));
                cl.setDocumento(rs.getString("documento"));
                cl.setNombre(rs.getString("nombre"));
                cl.setCelular(rs.getString("celular"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setCorreo(rs.getString("correo"));
                cl.setEstado(rs.getString("estado"));
                ListaCli.add(cl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes: " + e.getMessage());
        }
        return ListaCli;
    }
     
    //BUSCAR CLIENTES EN LA NUEVA VENTA
    public Clientes Buscarclientes(int dni){
        Clientes cl = null;
        String sql = "SELECT * FROM clientes WHERE documento = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl = new Clientes();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDocumento(rs.getString("documento"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setCelular(rs.getString("celular"));
                cl.setEstado(rs.getString("estado"));
                
            }
        } catch (SQLException e) {
           System.out.println(e.toString());
        }
        return cl;
    }
}
