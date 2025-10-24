package Dao;

import Resources.Conexion;
import java.sql.*;
import Models.Configuracion;
import javax.swing.JOptionPane;

public class DAO_Configuracion {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    //OBTENER LOS DATOS DE LA EMPRESA EN LA BASE DE DATOS
    public Configuracion ObtenerDatosE(){
        Configuracion conf = null;
        String sql = "SELECT * FROM configuracion WHERE id = 1";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                conf = new Configuracion();
                conf.setId(rs.getInt("id"));
                conf.setRuc(rs.getLong("ruc"));
                conf.setNombre(rs.getString("nombre"));
                conf.setCelular(rs.getLong("celular"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setMensaje(rs.getString("mensaje"));
            }
        }catch (SQLException e){
            System.out.println("Error al obtener los datos de la emrpesa: " + e);
        }
        return conf;
    }
    
    //ACTUALIZAR LOS DATOS DE LA EMPRESA
    public boolean ActualizarDatosE(Configuracion conf){
        String sql = "UPDATE configuracion SET ruc=?, nombre=?, celular=?, direccion=?, mensaje=? WHERE id=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setLong(3, conf.getCelular());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getMensaje());
            ps.setInt(6, conf.getId());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("Erro al actualizar los datos de la empresa: " + e);
            return false;
        }
    }

    //OBTENER LOS DATOS DE LA EMPRESA PARA EL VOUCHER
    public Configuracion ObtenerDatosEmpresa() {
        Configuracion emp = new Configuracion();
        String sql = "SELECT * FROM configuracion LIMIT 1";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setRuc(rs.getLong("ruc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setCelular(rs.getLong("celular"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setMensaje(rs.getString("mensaje"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
}
