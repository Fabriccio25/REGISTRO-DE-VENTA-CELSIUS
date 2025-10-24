package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Resources.Conexion;
import Models.Productos;
import javax.swing.JOptionPane;

public class DAO_Productos {
    
    //CONEXION A LA BASE DE DATOS
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //REGISTRAR A LOS NUEVOS USUARIOS
    public boolean RegistrarProductos(Productos pr){
        String sql = "INSERT INTO productos (codigo, nombre, descripcion, tipo_hielo, peso, precio, stock, fecha_registro, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getDescripcion());
            ps.setString(4, pr.getTipo_hielo());
            ps.setInt(5, pr.getPeso());
            ps.setDouble(6, pr.getPrecio());
            ps.setInt(7, pr.getStock());
            ps.setDate(8, java.sql.Date.valueOf(pr.getFecha_registro()));
            ps.setString(9, pr.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto: " + e.getMessage());
            return false;
        }
    }
    //ELIMINAR PRODUCTOS REGISTRADOS
    public boolean EliminarProductos(int id){
       String sql = "DELETE FROM productos WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
    //MODIFICAR PRODUCTOS REGISTRADOS
    public boolean ModificarProductos(Productos pro){
       String sql = "UPDATE productos SET codigo=?, nombre=?, descripcion=?, tipo_hielo=?, peso=?, precio=?, stock=?, fecha_registro=?, estado=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getTipo_hielo());
            ps.setInt(5, pro.getPeso());
            ps.setDouble(6, pro.getPrecio());
            ps.setInt(7, pro.getStock());
            ps.setDate(8, java.sql.Date.valueOf(pro.getFecha_registro()));
            ps.setString(9, pro.getEstado());
            ps.setInt(10, pro.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto: " + e.getMessage());
            return false;
        }
    }
    //LISTAR PRODUCTOS EN LA TABLA
    public List ListarProductos(){
        List<Productos> ListaPro = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pr = new Productos();
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setTipo_hielo(rs.getString("tipo_hielo"));
                pr.setPeso(rs.getInt("peso"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setStock(rs.getInt("stock"));
                pr.setFecha_registro(rs.getDate("fecha_registro").toLocalDate());
                pr.setEstado(rs.getString("estado"));
                ListaPro.add(pr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar productos: " + e.getMessage());
        }
        return ListaPro;
    }
    
    //BUSCAR PRODUCTO EN LA TABLA DE VENTA
    public Productos BuscarProducto(String cod) {
    Productos producto = null;
    String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Productos();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setTipo_hielo(rs.getString("tipo_hielo"));
                producto.setPeso(rs.getInt("peso"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

                java.sql.Date fecha = rs.getDate("fecha_registro");
                if (fecha != null) {
                    producto.setFecha_registro(fecha.toLocalDate());
                }
                producto.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.toString());
        }
        return producto;
    }
    
    //AUMETAR STOCK AL QUITAR UN PRODUCTO
    public void AumentarStock(int cantidad, String codigo) {
        String sql = "UPDATE productos SET stock = stock + ? WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al aumentar stock: " + e.toString());
        }
    }
    //RESTAR STOCK AL AGREGAR UN PRODUCTO
    public void DisminuirStock(int cantidad, String codigo) {
        String sql = "UPDATE productos SET stock = stock - ? WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al disminuir stock: " + e.toString());
        }
    }
}
