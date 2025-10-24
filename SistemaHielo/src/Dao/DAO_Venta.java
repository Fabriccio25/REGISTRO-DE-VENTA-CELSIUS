package Dao;
import Resources.Conexion;
import java.sql.*;
import Models.Venta;
import Models.Detalle;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DAO_Venta {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    //INSERTAR LA VENTA Y DEVOLVER EL ID GENERADO
    public int registrarVenta(Venta v) {
        int idVenta = 0;
        String sql = "INSERT INTO venta (dni_cliente, nombre_cliente, total_pagar, metodo_pago, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getDniCliente());
            ps.setString(2, v.getNombreCliente());
            ps.setDouble(3, v.getTotalPagar());
            ps.setString(4, v.getMetodoPago());
            ps.setString(5, v.getEstado());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error registrar venta: " + e);
        }
        return idVenta;
    }
    
    //INSERTAR EL DETALLE
    public int registrarDetalleVenta(Detalle dv) {
        String sql = "INSERT INTO detalle_venta (id_venta, codigo_producto, nombre_producto, tipo, peso, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVenta());
            ps.setString(2, dv.getCodigoProducto());
            ps.setString(3, dv.getNombreProducto());
            ps.setString(4, dv.getTipo());
            ps.setDouble(5, dv.getPeso());
            ps.setInt(6, dv.getCantidad());
            ps.setDouble(7, dv.getPrecioUnitario());
            ps.setDouble(8, dv.getSubtotal());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error registrar detalle: " + e);
        }
        return r;
    }
    
    //APACHE POI
    //EXPORTAR LAS VENTAS EN EXCEL
    public void ExportarExcelVentas(String query, String tipoInforme) {
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            //CREAR EL EXCEL
            org.apache.poi.ss.usermodel.Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Informe de Ventas");

            //ENCABEZADO
            org.apache.poi.ss.usermodel.Row header = sheet.createRow(0);
            String[] columnas = {"ID Venta", "DNI Cliente", "Nombre Cliente", "Fecha Venta", "Total (S/)", "Método de Pago", "Estado"};
            for (int i = 0; i < columnas.length; i++) {
                org.apache.poi.ss.usermodel.Cell cell = header.createCell(i);
                cell.setCellValue(columnas[i]);
            }

            //LLENA LOS DATOS
            int rowNum = 1;
            while (rs.next()) {
                org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getInt("id_venta"));
                row.createCell(1).setCellValue(rs.getString("dni_cliente"));
                row.createCell(2).setCellValue(rs.getString("nombre_cliente"));
                row.createCell(3).setCellValue(rs.getString("fecha_venta"));
                row.createCell(4).setCellValue(rs.getDouble("total_pagar"));
                row.createCell(5).setCellValue(rs.getString("metodo_pago"));
                row.createCell(6).setCellValue(rs.getString("estado"));
            }

            //AJUSTA AUTOMATICAMENTE LAS COLUMNAS
            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            //OBTEER LA FECHA PARA LA EXPORTACION
            java.time.LocalDate hoy = java.time.LocalDate.now();
            String fechaActual = hoy.toString();
            String mesActual = hoy.getMonth().toString();
            int añoActual = hoy.getYear();
            
            //CREA CARPETA EN DOCUMENTO
            String rutaCarpeta = System.getProperty("user.home") + "/Documents/INFORMES_VENTAS";
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            //GUARDA EL ARCHIVO CON UN UNICO NOMBRE
            String rutaBase = System.getProperty("user.home") + "/Documents/INFORMES";
            File carpetaPrincipal = new File(rutaBase);
            if (!carpetaPrincipal.exists()) carpetaPrincipal.mkdirs();

                String subRuta = "";
                switch (tipoInforme) {
                    case "Informe Diario":
                        subRuta = rutaBase + "/DIA/" + fechaActual;
                        break;
                    case "Informe Mensual":
                        subRuta = rutaBase + "/MES/" + mesActual + "_" + añoActual;
                        break;
                    case "Informe Anual":
                        subRuta = rutaBase + "/AÑO/" + añoActual;
                        break;
                }

                //CREAR SUBCARPETA POR SI NO EXSTE
                File carpetaTipo = new File(subRuta);
                if (!carpetaTipo.exists()) carpetaTipo.mkdirs();

                //NOMBRE DEL ARCHUVO
                String rutaArchivo = subRuta + "/Informe_" + tipoInforme.replace(" ", "_") + "_" + fechaActual + ".xlsx";

                //GUARDAR EL ARCHIVP EXCEL
                FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
                workbook.write(fileOut);
                workbook.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Informe generado con éxito:\n" + rutaArchivo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al generar informe: " + e.getMessage());
            }
    }
    
    //LISTAR VENTASS
    public List<Venta> ListarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta ORDER BY id_venta DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("id_venta"));
                v.setDniCliente(rs.getString("dni_cliente"));
                v.setNombreCliente(rs.getString("nombre_cliente"));
                v.setFechaVenta(rs.getString("fecha_venta"));
                v.setTotalPagar(rs.getBigDecimal("total_pagar").doubleValue());
                v.setMetodoPago(rs.getString("metodo_pago"));
                v.setEstado(rs.getString("estado"));
                lista.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return lista;
    }
}
