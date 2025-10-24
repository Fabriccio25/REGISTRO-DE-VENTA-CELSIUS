package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Resources.Conexion;
import Models.Proveedores;
import javax.swing.JOptionPane;

public class DAO_Proveedores {
    //CONEXION A LA BASE DE DATOS
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //REGISTRAR A LOS NUEVOS PROVEEDORES
    public boolean RegistrarProveedores(Proveedores pr) {
        String sql = "INSERT INTO proveedores (codigo, nombre, ruc, direccion, celular, correo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getRuc());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getCelular());
            ps.setString(6, pr.getCorreo());
            ps.setString(7, pr.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar proveedor: " + e.getMessage());
            return false;
        }
    }
    // MODIFICAR PROVEEDOR
    public boolean ModificarProveedor(Proveedores pr) {
        String sql = "UPDATE proveedores SET codigo=?, nombre=?, ruc=?, direccion=?, celular=?, correo=?, estado=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getRuc());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getCelular());
            ps.setString(6, pr.getCorreo());
            ps.setString(7, pr.getEstado());
            ps.setInt(8, pr.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar proveedor: " + e.getMessage());
            return false;
        }
    }
    // ELIMINAR PROVEEDOR
    public boolean EliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }
    
    // LISTAR PROVEEDORES
    public List<Proveedores> ListarProveedores() {
        List<Proveedores> ListaPro = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedores pr = new Proveedores();
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setRuc(rs.getString("ruc"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCelular(rs.getString("celular"));
                pr.setCorreo(rs.getString("correo"));
                pr.setEstado(rs.getString("estado"));
                ListaPro.add(pr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar proveedores: " + e.getMessage());
        }
        return ListaPro;
    }
}
