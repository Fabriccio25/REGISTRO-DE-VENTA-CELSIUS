package Views;

import Models.*;
import Dao.*;
import Resources.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;



public class InterfazV extends javax.swing.JFrame {
    
    Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    
    //MODEL
    Clientes cl = new Clientes();
    Productos pro = new Productos();
    Proveedores pr = new Proveedores();
    Login lg = new Login();
    Configuracion conf = new Configuracion();
    Usuarios user = new Usuarios();
    
    //ADICIONAL
    Eventos event = new Eventos();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //DAO
    DAO_Clientes DAOcli = new DAO_Clientes();
    DAO_Productos DAOpro = new DAO_Productos();
    DAO_Proveedores DAOprov = new DAO_Proveedores();
    DAO_Login DAOlog = new DAO_Login();
    DAO_Configuracion DAOconf = new DAO_Configuracion();
    DAO_Usuarios DAOuser = new DAO_Usuarios();
    
    int item;
    double Totalpagar = 0.00;
    
    
    // RECIBE EL USUARIO LOGEADO
    public InterfazV(Login usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //OCULTAR LOS ID
        txtIdC.setVisible(false);
        txtIdCV.setVisible(false);
        txtIdE.setVisible(false);
        txtIdI.setVisible(false);
        txtIdP.setVisible(false);
        txtIdPV.setVisible(false);
        txtIdV.setVisible(false);
        txtIdA.setVisible(false);

        
        //MUESTRA EL NOMBRE Y ROL
        lblUsuarioU.setText(usuario.getNombre());
        lblRolU.setText(usuario.getRol());
        
        //PERMISOS DE LOS USUARIOS
        switch (usuario.getRol()){
            case "ADMINISTRADOR":
                break;
                
            case "VENDEDOR":
                bloquearPestanasE("1", "2");
                
                //BLOQUEAR BOTONES QUE NO ESTAN PERMITIDOS
                btnProducto.setEnabled(false);
                btnProveedor.setEnabled(false);
                btnInforme.setEnabled(false);
                btnConfiguracion.setEnabled(false);
                btnAdministrador.setEnabled(false);
                break;
                
            case "OPERADOR":
                bloquearPestanasE("3", "4");
                
                //BLOQUEAR BOTONES QUE NO ESTAN PERMITIDOS
                btnVenta.setEnabled(false);
                btnCliente.setEnabled(false);
                btnInforme.setEnabled(false);
                btnConfiguracion.setEnabled(false);
                btnAdministrador.setEnabled(false);
                
                //ABRE LA PESTAÑA DE PRODUCTOS DIRECTAMENTE
                jTablaVentas.setSelectedComponent(jpProductos);
                break;
                
            default:
                //BLOQUEAR TODOS LOS BOTONES PORQUE NO EXISTE ROL
                bloquearPestanasE();
                btnVenta.setEnabled(false);
                btnCliente.setEnabled(false);
                btnProducto.setEnabled(false);
                btnProveedor.setEnabled(false);
                btnInforme.setEnabled(false);
                btnConfiguracion.setEnabled(false);
                btnAdministrador.setEnabled(false);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProducto = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        lblUsuarioU = new javax.swing.JLabel();
        lblRolU = new javax.swing.JLabel();
        jTablaVentas = new javax.swing.JTabbedPane();
        jpNuevaVenta = new javax.swing.JPanel();
        txtCodigoV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreV = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPrecioV = new javax.swing.JTextField();
        txtStockV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBorrarV = new javax.swing.JButton();
        txtIdV = new javax.swing.JTextField();
        txtDniClienteV = new javax.swing.JTextField();
        txtNombreClienteV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTotalV = new javax.swing.JLabel();
        txtIdCV = new javax.swing.JTextField();
        btnVoucherV = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txtCantidadV = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtTipoV = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtPesoV = new javax.swing.JTextField();
        jpClientes = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDniC = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        txtCelularC = new javax.swing.JTextField();
        txtDireccionC = new javax.swing.JTextField();
        btnGuardarC = new javax.swing.JButton();
        btnModificarC = new javax.swing.JButton();
        btnEliminarC = new javax.swing.JButton();
        txtCorreoC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cbxEstadoC = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaC = new javax.swing.JTable();
        jpProductos = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPesoP = new javax.swing.JTextField();
        btnGuardarP = new javax.swing.JButton();
        btnModificarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        txtIdP = new javax.swing.JTextField();
        cbxTipoP = new javax.swing.JComboBox<>();
        txtNombreP = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtPrecioP = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtStockP = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtFechaRegistroP = new javax.swing.JTextField();
        cbxEstadoP = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDescripcionP = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();
        jpProveedores = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtCorreoPro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDireccionPro = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCelularPro = new javax.swing.JTextField();
        btnGuardarPro = new javax.swing.JButton();
        btnModificarPro = new javax.swing.JButton();
        btnEliminarPro = new javax.swing.JButton();
        txtIdPV = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        txtRucPro = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        cbxEstadoPro = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaPro = new javax.swing.JTable();
        jpInforme = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaInforme = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtIdI = new javax.swing.JTextField();
        jpConfiguracion = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtRucE = new javax.swing.JTextField();
        txtNombreE = new javax.swing.JTextField();
        txtCelularE = new javax.swing.JTextField();
        txtDireccionE = new javax.swing.JTextField();
        txtMensajeE = new javax.swing.JTextField();
        btnRegistrarE = new javax.swing.JButton();
        txtIdE = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jpAdministrador = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtUsuarioA = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtContrasenaA = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        cbxRolA = new javax.swing.JComboBox<>();
        btnRegistrarA = new javax.swing.JButton();
        txtCorreoA = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtIdA = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaAdministracion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/collab.png"))); // NOI18N

        btnProducto.setText("PRODUCTOS");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnCliente.setText("CLIENTES");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnInforme.setText("INFORME");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        btnVenta.setText("NUEVA VENTA");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnConfiguracion.setText("CONFIGURACION");
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        btnAdministrador.setText("ADMINISTRADOR");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });

        btnProveedor.setText("PROVEEDORES");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        lblUsuarioU.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuarioU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioU.setText("USUARIO");

        lblRolU.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRolU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRolU.setText("ROL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarioU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRolU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioU)
                .addGap(2, 2, 2)
                .addComponent(lblRolU)
                .addGap(12, 12, 12)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCodigoV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");

        txtNombreV.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Precio");

        txtPrecioV.setEnabled(false);

        txtStockV.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Stock");

        btnBorrarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnBorrarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVActionPerformed(evt);
            }
        });

        txtDniClienteV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniClienteVKeyPressed(evt);
            }
        });

        txtNombreClienteV.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("DNI");

        TablaV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "TIPO", "PESO", "CANTIDAD", "PRECIO UNIT", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaV);
        if (TablaV.getColumnModel().getColumnCount() > 0) {
            TablaV.getColumnModel().getColumn(0).setPreferredWidth(30);
            TablaV.getColumnModel().getColumn(1).setPreferredWidth(40);
            TablaV.getColumnModel().getColumn(2).setPreferredWidth(30);
            TablaV.getColumnModel().getColumn(3).setPreferredWidth(30);
            TablaV.getColumnModel().getColumn(4).setPreferredWidth(30);
            TablaV.getColumnModel().getColumn(5).setPreferredWidth(40);
            TablaV.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Total de pagar");

        lblTotalV.setText("--------------");

        btnVoucherV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print.png"))); // NOI18N
        btnVoucherV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherVActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("NOMBRE");

        txtCantidadV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVKeyTyped(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setText("Cantidad");

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setText("Tipo");

        txtTipoV.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Peso");

        txtPesoV.setEnabled(false);

        javax.swing.GroupLayout jpNuevaVentaLayout = new javax.swing.GroupLayout(jpNuevaVenta);
        jpNuevaVenta.setLayout(jpNuevaVentaLayout);
        jpNuevaVentaLayout.setHorizontalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigoV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreV)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipoV, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPesoV, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidadV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecioV, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStockV, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addComponent(btnBorrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdV, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDniClienteV, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreClienteV)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnVoucherV)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalV, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jpNuevaVentaLayout.setVerticalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPesoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTipoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                                    .addComponent(txtIdV, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))))
                    .addComponent(txtCantidadV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBorrarV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel38))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDniClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreClienteV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnVoucherV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTotalV))
                        .addGap(19, 19, 19))))
        );

        jTablaVentas.addTab("1", jpNuevaVenta);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Clientes"));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("DNI / RUC");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Direccion");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Celular");

        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar.png"))); // NOI18N
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnModificarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar.png"))); // NOI18N
        btnModificarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCActionPerformed(evt);
            }
        });

        btnEliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Correo");

        txtIdC.setBorder(null);
        txtIdC.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel37.setText("Estado");

        cbxEstadoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxEstadoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreC)
                    .addComponent(txtCelularC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreoC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDniC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnGuardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelularC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI / RUC", "NOMBRE", "CELULAR", "DIRECCION", "CORREO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaC);
        if (TablaC.getColumnModel().getColumnCount() > 0) {
            TablaC.getColumnModel().getColumn(0).setMinWidth(10);
            TablaC.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablaC.getColumnModel().getColumn(0).setMaxWidth(100);
            TablaC.getColumnModel().getColumn(1).setPreferredWidth(3);
            TablaC.getColumnModel().getColumn(2).setPreferredWidth(30);
            TablaC.getColumnModel().getColumn(3).setPreferredWidth(20);
            TablaC.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jpClientesLayout = new javax.swing.GroupLayout(jpClientes);
        jpClientes.setLayout(jpClientesLayout);
        jpClientesLayout.setHorizontalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTablaVentas.addTab("2", jpClientes);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Productos"));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Codigo");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Descripcion");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Tipo");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Peso");

        btnGuardarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar.png"))); // NOI18N
        btnGuardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPActionPerformed(evt);
            }
        });

        btnModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar.png"))); // NOI18N
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });

        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        txtIdP.setBorder(null);
        txtIdP.setEnabled(false);

        cbxTipoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUBO", "BLOQUE", "ESCARCHA", "TRITURADO" }));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setText("Nombre");

        jLabel44.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel44.setText("Precio");

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel45.setText("Stock");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setText("Fecha Registro");

        cbxEstadoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel47.setText("Estado");

        txtDescripcionP.setColumns(1);
        txtDescripcionP.setRows(1);
        jScrollPane7.setViewportView(txtDescripcionP);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEstadoP, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPesoP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtPrecioP)))
                            .addComponent(cbxTipoP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(txtFechaRegistroP)))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardarP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaRegistroP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "DESCRIPCION", "TIPO", "PESO", "PRECIO", "STOCK", "FECHA REG", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaP);
        if (TablaP.getColumnModel().getColumnCount() > 0) {
            TablaP.getColumnModel().getColumn(0).setMinWidth(10);
            TablaP.getColumnModel().getColumn(0).setPreferredWidth(30);
            TablaP.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jpProductosLayout = new javax.swing.GroupLayout(jpProductos);
        jpProductos.setLayout(jpProductosLayout);
        jpProductosLayout.setHorizontalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpProductosLayout.setVerticalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTablaVentas.addTab("3", jpProductos);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Correo");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Direccion");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Celular");

        btnGuardarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar.png"))); // NOI18N
        btnGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProActionPerformed(evt);
            }
        });

        btnModificarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar.png"))); // NOI18N
        btnModificarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProActionPerformed(evt);
            }
        });

        btnEliminarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProActionPerformed(evt);
            }
        });

        txtIdPV.setBorder(null);
        txtIdPV.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Codigo");

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel49.setText("RUC");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel48.setText("Nombre");

        cbxEstadoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel50.setText("Estado");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxEstadoPro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreoPro)
                            .addComponent(txtDireccionPro)
                            .addComponent(txtCelularPro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPro)
                            .addComponent(txtRucPro)
                            .addComponent(txtNombrePro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(txtIdPV, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnModificarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRucPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelularPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        TablaPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "RUC", "DIRECCION", "CELULAR", "CORREO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablaPro);
        if (TablaPro.getColumnModel().getColumnCount() > 0) {
            TablaPro.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jpProveedoresLayout = new javax.swing.GroupLayout(jpProveedores);
        jpProveedores.setLayout(jpProveedoresLayout);
        jpProveedoresLayout.setHorizontalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpProveedoresLayout.setVerticalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTablaVentas.addTab("4", jpProveedores);

        TablaInforme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        jScrollPane4.setViewportView(TablaInforme);
        if (TablaInforme.getColumnModel().getColumnCount() > 0) {
            TablaInforme.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaInforme.getColumnModel().getColumn(1).setPreferredWidth(60);
            TablaInforme.getColumnModel().getColumn(2).setPreferredWidth(60);
            TablaInforme.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print.png"))); // NOI18N
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Codigo");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Historial de Ventas");

        javax.swing.GroupLayout jpInformeLayout = new javax.swing.GroupLayout(jpInforme);
        jpInforme.setLayout(jpInformeLayout);
        jpInformeLayout.setHorizontalGroup(
            jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInformeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE)
                    .addGroup(jpInformeLayout.createSequentialGroup()
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdI, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(345, 345, 345)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInformeLayout.createSequentialGroup()
                    .addContainerGap(550, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addContainerGap(550, Short.MAX_VALUE)))
        );
        jpInformeLayout.setVerticalGroup(
            jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInformeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInformeLayout.createSequentialGroup()
                    .addGap(0, 208, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTablaVentas.addTab("5", jpInforme);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Datos de la Empresa");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("RUC");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("NOMBRE");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("DIRECCION");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("CELULAR");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("MENSAJE");

        btnRegistrarE.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarE.setText("Actualizar");
        btnRegistrarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionE)
                            .addComponent(txtMensajeE, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addComponent(txtRucE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCelularE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMensajeE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/configuracionx.png"))); // NOI18N

        javax.swing.GroupLayout jpConfiguracionLayout = new javax.swing.GroupLayout(jpConfiguracion);
        jpConfiguracion.setLayout(jpConfiguracionLayout);
        jpConfiguracionLayout.setHorizontalGroup(
            jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(16, 16, 16))
            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpConfiguracionLayout.setVerticalGroup(
            jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConfiguracionLayout.createSequentialGroup()
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpConfiguracionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpConfiguracionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );

        jTablaVentas.addTab("6", jpConfiguracion);

        jpAdministrador.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iniciar.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("Usuario");

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setText("Contraseña");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel35.setText("Nombre");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setText("Rol");

        cbxRolA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VENDEDOR", "OPERADOR", "ADMINISTRADOR" }));

        btnRegistrarA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarA.setText("Registrar");
        btnRegistrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel51.setText("Correo");

        txtIdA.setEditable(false);
        txtIdA.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel39))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtIdA, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrarA)
                                .addGap(50, 50, 50))
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuarioA)
                            .addComponent(txtContrasenaA)
                            .addComponent(txtNombreA)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxRolA, 0, 204, Short.MAX_VALUE)
                            .addComponent(txtCorreoA)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuarioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxRolA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        TablaAdministracion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "CONTRASEÑA", "NOMBRE", "CORREO", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaAdministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAdministracionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablaAdministracion);
        if (TablaAdministracion.getColumnModel().getColumnCount() > 0) {
            TablaAdministracion.getColumnModel().getColumn(0).setResizable(false);
            TablaAdministracion.getColumnModel().getColumn(0).setPreferredWidth(10);
            TablaAdministracion.getColumnModel().getColumn(1).setResizable(false);
            TablaAdministracion.getColumnModel().getColumn(2).setResizable(false);
            TablaAdministracion.getColumnModel().getColumn(3).setResizable(false);
            TablaAdministracion.getColumnModel().getColumn(4).setResizable(false);
            TablaAdministracion.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jpAdministradorLayout = new javax.swing.GroupLayout(jpAdministrador);
        jpAdministrador.setLayout(jpAdministradorLayout);
        jpAdministradorLayout.setHorizontalGroup(
            jpAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdministradorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpAdministradorLayout.setVerticalGroup(
            jpAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdministradorLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jpAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTablaVentas.addTab("7", jpAdministrador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTablaVentas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jTablaVentas)
                .addContainerGap())
        );

        jTablaVentas.getAccessibleContext().setAccessibleName("1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        jTablaVentas.setSelectedIndex(2);
        ListarProducto();
        LimpiarProducto();
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        jTablaVentas.setSelectedIndex(1);
        LimpiarTabla(TablaC);
        ListarCliente();
        LimpiarCliente();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        jTablaVentas.setSelectedIndex(0);
        LimpiarVenta();
    }//GEN-LAST:event_btnVentaActionPerformed
    
    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        jTablaVentas.setSelectedIndex(5);
        CargarDatosE();
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void txtCodigoVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String cod = txtCodigoV.getText().trim();
            
            //VALIDA EL CAMPO DE CODIGO SI ESTA VACIO
            if (cod.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el código del producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtCodigoV.requestFocus();
                return;
            }
            
            //BUSCAR EL PRODUCTO EN LA BD
            Productos pro = DAOpro.BuscarProducto(cod);
            
            //VALIDA EL CAMPO DE CODIGO SI NO EXISTE
            if (pro == null) {
                JOptionPane.showMessageDialog(null, "El código ingresado no existe o es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                LimpiarVenta();
                txtCodigoV.requestFocus();
                return;
            }
            
            //MUESTRA LOS DATOS DEL PRODUCTO QUE ENCONTRO EN LA BD
            txtIdP.setText(String.valueOf(pro.getId()));
            txtNombreV.setText(pro.getNombre());
            txtTipoV.setText(pro.getTipo_hielo());
            txtPesoV.setText(String.valueOf(pro.getPeso()));
            txtPrecioV.setText(String.valueOf(pro.getPrecio()));
            txtStockV.setText(String.valueOf(pro.getStock()));
            
            txtCantidadV.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoVKeyPressed

    private void btnBorrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) TablaV.getModel();
        int filaSeleccionada = TablaV.getSelectedRow();

        // VALIDAR SI NO TIENES UNA FILA SELECCIONADA
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // CONFIRMAR SI DESEAS ELIMINAR
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la fila seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            String codigo = modelo.getValueAt(filaSeleccionada, 0).toString();
            int cantidadEliminada = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 4).toString());

            DAOpro.AumentarStock(cantidadEliminada, codigo);
            modelo.removeRow(filaSeleccionada);

            TotalPagar();

            Productos p = DAOpro.BuscarProducto(codigo);
            if (p != null) {
                txtStockV.setText(String.valueOf(p.getStock()));
            }
            txtCodigoV.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarVActionPerformed

    private void txtDniClienteVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteVKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String dniStr = txtDniClienteV.getText().trim();

            if (dniStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el DNI del cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtDniClienteV.requestFocus();
                return;
            }

            int dni = Integer.parseInt(dniStr);
            cl = DAOcli.Buscarclientes(dni);

            if (cl != null) {
                txtNombreClienteV.setText(cl.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado. Verifique el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
                txtNombreClienteV.setText("");
            }
        btnVoucherV.requestFocus();
        } 
    }//GEN-LAST:event_txtDniClienteVKeyPressed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        String dni = txtDniC.getText().trim();
        String nombre = txtNombreC.getText().trim();
        String celular = txtCelularC.getText().trim();
        String direccion = txtDireccionC.getText().trim();
        String correo = txtCorreoC.getText().trim();
        String estado = cbxEstadoC.getSelectedItem().toString();

        // VALIDAR QUE EL CAMPO NO ESTE VACIO
        if (dni.isEmpty() || nombre.isEmpty() || celular.isEmpty() || direccion.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Clientes cl = new Clientes();
        cl.setDocumento(dni);
        cl.setNombre(nombre);
        cl.setCelular(celular);
        cl.setDireccion(direccion);
        cl.setCorreo(correo);
        cl.setEstado(estado);

        if (DAOcli.RegistrarClientes(cl)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
            LimpiarCliente(); 
            ListarCliente(); 
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnModificarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCActionPerformed
         if (txtDniC.getText().isEmpty() || txtNombreC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Clientes cl = new Clientes();
        cl.setDocumento(txtDniC.getText());
        cl.setNombre(txtNombreC.getText());
        cl.setCelular(txtCelularC.getText());
        cl.setDireccion(txtDireccionC.getText());
        cl.setCorreo(txtCorreoC.getText());
        cl.setEstado(cbxEstadoC.getSelectedItem().toString());

        // OBTENER EL ID DEL CLIENTE SELECCIONADO
        int fila = TablaC.getSelectedRow();
        cl.setId(Integer.parseInt(TablaC.getValueAt(fila, 0).toString()));

        // ACTUALIZAR EN LA BD
        DAOcli.ModificarClientes(cl);

        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
        LimpiarTablaC();
        ListarCliente();
        LimpiarCliente();
    }//GEN-LAST:event_btnModificarCActionPerformed

    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        int fila = TablaC.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente en la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(TablaC.getValueAt(fila, 0).toString());

            if (DAOcli.EliminarClientes(id)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                LimpiarTablaC();
                ListarCliente();
                LimpiarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente.");
            }
        }
    }//GEN-LAST:event_btnEliminarCActionPerformed

    private void TablaCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCMouseClicked
        int fila = TablaC.rowAtPoint(evt.getPoint());
    
        txtDniC.setText(TablaC.getValueAt(fila, 1).toString());
        txtNombreC.setText(TablaC.getValueAt(fila, 2).toString());
        txtCelularC.setText(TablaC.getValueAt(fila, 3).toString());
        txtDireccionC.setText(TablaC.getValueAt(fila, 4).toString());
        txtCorreoC.setText(TablaC.getValueAt(fila, 5).toString());
        cbxEstadoC.setSelectedItem(TablaC.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_TablaCMouseClicked

    private void TablaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPMouseClicked
        int fila = TablaP.rowAtPoint(evt.getPoint());
        if (fila >= 0) {
            txtCodigoP.setText(TablaP.getValueAt(fila, 1).toString());
            txtNombreP.setText(TablaP.getValueAt(fila, 2).toString());
            txtDescripcionP.setText(TablaP.getValueAt(fila, 3).toString());
            cbxTipoP.setSelectedItem(TablaP.getValueAt(fila, 4).toString());
            txtPesoP.setText(TablaP.getValueAt(fila, 5).toString());
            txtPrecioP.setText(TablaP.getValueAt(fila, 6).toString());
            txtStockP.setText(TablaP.getValueAt(fila, 7).toString());
            txtFechaRegistroP.setText(TablaP.getValueAt(fila, 8).toString());
            cbxEstadoP.setSelectedItem(TablaP.getValueAt(fila, 9).toString());
        }
    }//GEN-LAST:event_TablaPMouseClicked

    private void btnGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProActionPerformed
        if (!txtCodigoPro.getText().isEmpty() && !txtNombrePro.getText().isEmpty() && !txtRucPro.getText().isEmpty() && !txtDireccionPro.getText().isEmpty() && !txtCelularPro.getText().isEmpty() && !txtCorreoPro.getText().isEmpty()) {

            Proveedores pr = new Proveedores();
            pr.setCodigo(txtCodigoPro.getText());
            pr.setNombre(txtNombrePro.getText());
            pr.setRuc(txtRucPro.getText());
            pr.setDireccion(txtDireccionPro.getText());
            pr.setCelular(txtCelularPro.getText());
            pr.setCorreo(txtCorreoPro.getText());
            pr.setEstado(cbxEstadoPro.getSelectedItem().toString());

            if (DAOprov.RegistrarProveedores(pr)) {
                JOptionPane.showMessageDialog(null, "Proveedor registrado correctamente");
                LimpiarProveedor();
                ListarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar proveedor");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        }
    }//GEN-LAST:event_btnGuardarProActionPerformed

    private void btnModificarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProActionPerformed
        int fila = TablaPro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor para modificar.");
            return;
        }

        if (txtCodigoPro.getText().isEmpty() || txtNombrePro.getText().isEmpty() ||
            txtRucPro.getText().isEmpty() || txtDireccionPro.getText().isEmpty() ||
            txtCelularPro.getText().isEmpty() || txtCorreoPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
            return;
        }

        int id = Integer.parseInt(TablaPro.getValueAt(fila, 0).toString());

        Proveedores pr = new Proveedores();
        pr.setId(id);
        pr.setCodigo(txtCodigoPro.getText());
        pr.setNombre(txtNombrePro.getText());
        pr.setRuc(txtRucPro.getText());
        pr.setDireccion(txtDireccionPro.getText());
        pr.setCelular(txtCelularPro.getText());
        pr.setCorreo(txtCorreoPro.getText());
        pr.setEstado(cbxEstadoPro.getSelectedItem().toString());

        if (DAOprov.ModificarProveedor(pr)) {
            JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente");
            LimpiarProveedor();
            ListarProveedor();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar el proveedor");
        }
    }//GEN-LAST:event_btnModificarProActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
        int fila = TablaPro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor para eliminar.");
            return;
        }

        int id = Integer.parseInt(TablaPro.getValueAt(fila, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (DAOprov.EliminarProveedor(id)) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
                LimpiarProveedor();
                ListarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor.");
            }
        }
    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void TablaProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProMouseClicked
        int fila = TablaPro.rowAtPoint(evt.getPoint());
        if (fila >= 0) {
            txtCodigoPro.setText(TablaPro.getValueAt(fila, 1).toString());
            txtNombrePro.setText(TablaPro.getValueAt(fila, 2).toString());
            txtRucPro.setText(TablaPro.getValueAt(fila, 3).toString());
            txtDireccionPro.setText(TablaPro.getValueAt(fila, 4).toString());
            txtCelularPro.setText(TablaPro.getValueAt(fila, 5).toString());
            txtCorreoPro.setText(TablaPro.getValueAt(fila, 6).toString());
            cbxEstadoPro.setSelectedItem(TablaPro.getValueAt(fila, 7).toString());
        }
    }//GEN-LAST:event_TablaProMouseClicked

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        jTablaVentas.setSelectedIndex(6);
        ListarUsuario();
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        jTablaVentas.setSelectedIndex(3);
         ListarProveedor();
         LimpiarProveedor();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void TablaAdministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAdministracionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaAdministracionMouseClicked

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        jTablaVentas.setSelectedIndex(4);
        DAO_Venta dao = new DAO_Venta();
        List<Venta> lista = dao.ListarVentas();

        DefaultTableModel modelo = (DefaultTableModel) TablaInforme.getModel();
        modelo.setRowCount(0);

        for (Venta v : lista) {
            modelo.addRow(new Object[]{v.getIdVenta(), v.getDniCliente(), v.getNombreCliente(), v.getFechaVenta(), v.getTotalPagar(), v.getMetodoPago(), v.getEstado()});
        }
    }//GEN-LAST:event_btnInformeActionPerformed

    private void txtCodigoVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoVKeyTyped

    private void txtCantidadVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadVKeyTyped

    private void txtCantidadVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cantidadStr = txtCantidadV.getText().trim();

            // VALIDAR QUE SE HAYA INGRESADO CANTIDAD
            if (cantidadStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad del producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtCantidadV.requestFocus();
                return;
            }
            
            //VALIDAR QUE TENGA UN NUMERO MAYOR A CERO
            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor que cero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtCantidadV.setText("");
                txtCantidadV.requestFocus();
                return;
            }

            // VALIDAR SI HAY UN NUMERO EN STOCK
            if (txtStockV.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay informacion de stock para este producto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // VALIDA SI HAY STOCK DISPONIBLE
            int stock;
            try {
                stock = Integer.parseInt(txtStockV.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Stock invalido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // VALIDA SI EXISTE EL CODIGO DEL PRODUCTO
            String codigo = txtCodigoV.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay código de producto.", "Error", JOptionPane.ERROR_MESSAGE);
                txtCodigoV.requestFocus();
                return;
            }

            String nombre = txtNombreV.getText();
            String tipo = txtTipoV.getText();
            String peso = txtPesoV.getText();

            double precio;
            try {
                precio = Double.parseDouble(txtPrecioV.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio invalido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel modelo = (DefaultTableModel) TablaV.getModel();

            // BUSCAR SI EL PRODUCTO YA ESTÁ EN LA TABLA (por código)
            int filaEncontrada = -1;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Object val = modelo.getValueAt(i, 0);
                if (val != null && codigo.equals(val.toString())) {
                    filaEncontrada = i;
                    break;
                }
            }

            if (filaEncontrada != -1) {  
                int cantidadExistente;
                try {
                    cantidadExistente = Integer.parseInt(modelo.getValueAt(filaEncontrada, 4).toString());
                } catch (Exception e) {
                    cantidadExistente = 0;
                }
                int nuevaCantidad = cantidadExistente + cantidad;

                if (nuevaCantidad > stock) {
                    JOptionPane.showMessageDialog(null, "La cantidad total supera las existencias disponibles (" + stock + ").", "Error", JOptionPane.ERROR_MESSAGE);
                    txtCantidadV.setText("");
                    txtCantidadV.requestFocus();
                    return;
                }

                double nuevoTotalFila = nuevaCantidad * precio;
                modelo.setValueAt(nuevaCantidad, filaEncontrada, 4);
                modelo.setValueAt(nuevoTotalFila, filaEncontrada, 6);

                DAOpro.DisminuirStock(cantidad, codigo);

            } else {
                if (cantidad > stock) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada supera las existencias.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtCantidadV.setText("");
                    txtCantidadV.requestFocus();
                    return;
                }

                double total = cantidad * precio;
                Object[] fila = new Object[7];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = tipo;
                fila[3] = peso;
                fila[4] = cantidad;
                fila[5] = precio;
                fila[6] = total;
                modelo.addRow(fila);

                DAOpro.DisminuirStock(cantidad, codigo);
            }

            TotalPagar();
            LimpiarVenta();
            txtCodigoV.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadVKeyPressed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
         int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(TablaP.getValueAt(fila, 0).toString());

            if (DAOpro.EliminarProductos(id)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                LimpiarProducto();
                ListarProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
        int fila = TablaP.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Productos pro = new Productos();
            pro.setId(Integer.parseInt(TablaP.getValueAt(fila, 0).toString()));
            pro.setCodigo(txtCodigoP.getText());
            pro.setNombre(txtNombreP.getText());
            pro.setDescripcion(txtDescripcionP.getText());
            pro.setTipo_hielo(cbxTipoP.getSelectedItem().toString());
            pro.setPeso(Integer.parseInt(txtPesoP.getText()));
            pro.setPrecio(Double.parseDouble(txtPrecioP.getText()));
            pro.setStock(Integer.parseInt(txtStockP.getText()));
            pro.setFecha_registro(java.time.LocalDate.parse(txtFechaRegistroP.getText()));
            pro.setEstado(cbxEstadoP.getSelectedItem().toString());

            if (DAOpro.ModificarProductos(pro)) {
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
                LimpiarProducto();
                ListarProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void btnGuardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPActionPerformed
        Productos pr = new Productos();

        // Obtener datos de los campos
        pr.setCodigo(txtCodigoP.getText().trim());
        pr.setNombre(txtNombreP.getText().trim());
        pr.setDescripcion(txtDescripcionP.getText().trim());
        pr.setTipo_hielo(cbxTipoP.getSelectedItem().toString());
        pr.setPeso(Integer.parseInt(txtPesoP.getText().trim()));
        pr.setPrecio(Double.parseDouble(txtPrecioP.getText().trim()));
        pr.setStock(Integer.parseInt(txtStockP.getText().trim()));

        try {
            LocalDate fecha = LocalDate.parse(txtFechaRegistroP.getText().trim());
            pr.setFecha_registro(fecha);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha invalido. Usa YYYY-MM-DD");
            txtFechaRegistroP.requestFocus();
            return;
        }

        pr.setEstado(cbxEstadoP.getSelectedItem().toString());

        if (DAOpro.RegistrarProductos(pr)) {
            JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");
            LimpiarProducto();
            ListarProducto();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el producto.");
        }
    }//GEN-LAST:event_btnGuardarPActionPerformed

    private void btnRegistrarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEActionPerformed
        try{
            conf.setId(1);
            conf.setRuc(Long.parseLong(txtRucE.getText()));
            conf.setNombre(txtNombreE.getText());
            conf.setDireccion(txtDireccionE.getText());
            conf.setCelular(Long.parseLong(txtCelularE.getText()));
            conf.setMensaje(txtMensajeE.getText());
            
            if(DAOconf.ActualizarDatosE(conf)){
                JOptionPane.showMessageDialog(null, "Los datos de la empresa se actualizaron.");
                CargarDatosE();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos.");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarEActionPerformed

    private void btnRegistrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAActionPerformed
        if (txtUsuarioA.getText().equals("") || txtContrasenaA.getText().equals("") || txtNombreA.getText().equals("") || txtCorreoA.getText().equals("") || cbxRolA.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        } else {
            Usuarios u = new Usuarios();
            DAO_Usuarios dao = new DAO_Usuarios();

            u.setUsuario(txtUsuarioA.getText());
            u.setContrasena(txtContrasenaA.getText());
            u.setNombre(txtNombreA.getText());
            u.setCorreo(txtCorreoA.getText());
            u.setRol(cbxRolA.getSelectedItem().toString());

            if (dao.registrarUsuario(u)) {
                JOptionPane.showMessageDialog(null, "El usuario ha sido registrado correctamente");
                LimpiarUsuario();
                ListarUsuario();
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo registrar al usuario");
            }
        }
    }//GEN-LAST:event_btnRegistrarAActionPerformed

    private void btnVoucherVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherVActionPerformed
        DAO_Venta dao = new DAO_Venta();
        Venta v = new Venta();
        
        v.setDniCliente(txtDniClienteV.getText());
        v.setNombreCliente(txtNombreClienteV.getText());
        v.setTotalPagar(Double.parseDouble(lblTotalV.getText()));
        v.setMetodoPago("Efectivo");
        v.setEstado("Pagado");
        
        //REGISTRAR LA VENTA Y TENER EL ID
        int idVenta = dao.registrarVenta(v);
        
        for (int i = 0; i < TablaV.getRowCount(); i++) {
            Detalle dv = new Detalle();
            dv.setIdVenta(idVenta);
            dv.setCodigoProducto(TablaV.getValueAt(i, 0).toString());
            dv.setNombreProducto(TablaV.getValueAt(i, 1).toString());
            dv.setTipo(TablaV.getValueAt(i, 2).toString());
            dv.setPeso(Double.parseDouble(TablaV.getValueAt(i, 3).toString()));
            dv.setCantidad(Integer.parseInt(TablaV.getValueAt(i, 4).toString()));
            dv.setPrecioUnitario(Double.parseDouble(TablaV.getValueAt(i, 5).toString()));
            dv.setSubtotal(Double.parseDouble(TablaV.getValueAt(i, 6).toString()));

            dao.registrarDetalleVenta(dv);
        }
        
        //GENERAR EL VOUCHER
        GenerarVoucher(idVenta);
        JOptionPane.showMessageDialog(null, "La venta se registro correctamente.");
        
        LimpiarVentaVoucher();
    }//GEN-LAST:event_btnVoucherVActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        String[] opciones = {"Informe Diario", "Informe Mensual", "Informe Anual"};
        String tipoInforme = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione el tipo de informe que desea generar:",
            "Generar Informe",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (tipoInforme != null) {
            DAO_Venta dao = new DAO_Venta();
            String query = "";

            switch (tipoInforme) {
                case "Informe Diario":
                    query = "SELECT * FROM venta WHERE DATE(fecha_venta) = CURDATE()";
                    break;

                case "Informe Mensual":
                    query = "SELECT * FROM venta WHERE MONTH(fecha_venta) = MONTH(CURDATE()) AND YEAR(fecha_venta) = YEAR(CURDATE())";
                    break;

                case "Informe Anual":
                    query = "SELECT * FROM venta WHERE YEAR(fecha_venta) = YEAR(CURDATE())";
                    break;
            }

            dao.ExportarExcelVentas(query, tipoInforme);
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginV().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAdministracion;
    private javax.swing.JTable TablaC;
    private javax.swing.JTable TablaInforme;
    private javax.swing.JTable TablaP;
    private javax.swing.JTable TablaPro;
    private javax.swing.JTable TablaV;
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnBorrarV;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnEliminarC;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnEliminarPro;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnGuardarP;
    private javax.swing.JButton btnGuardarPro;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnModificarC;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton btnModificarPro;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRegistrarA;
    private javax.swing.JButton btnRegistrarE;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton btnVoucherV;
    private javax.swing.JComboBox<String> cbxEstadoC;
    private javax.swing.JComboBox<String> cbxEstadoP;
    private javax.swing.JComboBox<String> cbxEstadoPro;
    private javax.swing.JComboBox<String> cbxRolA;
    private javax.swing.JComboBox<String> cbxTipoP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTablaVentas;
    private javax.swing.JPanel jpAdministrador;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpConfiguracion;
    private javax.swing.JPanel jpInforme;
    private javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JPanel jpProveedores;
    private javax.swing.JLabel lblRolU;
    private javax.swing.JLabel lblTotalV;
    private javax.swing.JLabel lblUsuarioU;
    private javax.swing.JTextField txtCantidadV;
    private javax.swing.JTextField txtCelularC;
    private javax.swing.JTextField txtCelularE;
    private javax.swing.JTextField txtCelularPro;
    private javax.swing.JTextField txtCodigoP;
    private javax.swing.JTextField txtCodigoPro;
    private javax.swing.JTextField txtCodigoV;
    private javax.swing.JTextField txtContrasenaA;
    private javax.swing.JTextField txtCorreoA;
    private javax.swing.JTextField txtCorreoC;
    private javax.swing.JTextField txtCorreoPro;
    private javax.swing.JTextArea txtDescripcionP;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtDireccionE;
    private javax.swing.JTextField txtDireccionPro;
    private javax.swing.JTextField txtDniC;
    private javax.swing.JTextField txtDniClienteV;
    private javax.swing.JTextField txtFechaRegistroP;
    private javax.swing.JTextField txtIdA;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtIdCV;
    private javax.swing.JTextField txtIdE;
    private javax.swing.JTextField txtIdI;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtIdPV;
    private javax.swing.JTextField txtIdV;
    private javax.swing.JTextField txtMensajeE;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreClienteV;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtNombrePro;
    private javax.swing.JTextField txtNombreV;
    private javax.swing.JTextField txtPesoP;
    private javax.swing.JTextField txtPesoV;
    private javax.swing.JTextField txtPrecioP;
    private javax.swing.JTextField txtPrecioV;
    private javax.swing.JTextField txtRucE;
    private javax.swing.JTextField txtRucPro;
    private javax.swing.JTextField txtStockP;
    private javax.swing.JTextField txtStockV;
    private javax.swing.JTextField txtTipoV;
    private javax.swing.JTextField txtUsuarioA;
    // End of variables declaration//GEN-END:variables
    
    //METODO PAA BLOQUEAR LAS PESTAÑAS NO PERMITIDAS SEGUN SU ROL
    private void bloquearPestanasE(String... permitidas) {
        for (int i = 0; i < jTablaVentas.getTabCount(); i++) {
        String titulo = jTablaVentas.getTitleAt(i);
        boolean permitido = false;

            for (String p : permitidas) {
                if (titulo.equalsIgnoreCase(p)) {
                    permitido = true;
                    break;
                }
            }

        // SI NO ESTA PERMITIDO SE DESACTIVA
        jTablaVentas.setEnabledAt(i, permitido);
        }
    }
    private void LimpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    //NUEVA VENTA
    private void TotalPagar(){
        double totalPagar = 0.0;
        DefaultTableModel modelo = (DefaultTableModel) TablaV.getModel();
        int numFila = modelo.getRowCount();

        for (int i = 0; i < numFila; i++) {
            Object val = modelo.getValueAt(i, 6);
            if (val != null) {
                try {
                    totalPagar += Double.parseDouble(val.toString());
                } catch (NumberFormatException e) {}
            }
        }
        lblTotalV.setText(String.format("%.2f", totalPagar));
    }
    private void LimpiarVenta(){
        txtCodigoV.setText("");
        txtIdP.setText("");
        txtNombreV.setText("");
        txtTipoV.setText("");
        txtPesoV.setText("");
        txtPrecioV.setText("");
        txtStockV.setText("");
        txtCantidadV.setText("");
    }
    private void LimpiarVentaVoucher(){
        txtDniClienteV.setText("");
        txtNombreClienteV.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) TablaV.getModel();
        modelo.setRowCount(0);
        lblTotalV.setText("--------------");
    }
    private void GenerarVoucher(int idVenta){
        DAO_Configuracion DAOconf = new DAO_Configuracion();
        Configuracion conf = DAOconf.ObtenerDatosEmpresa();

        Document doc = new Document(PageSize.A5);
        try {
            //CREAR RUTA EN DOCUMENTOS/VOUCHERS_VENDEDOR
            String rutaCarpeta = System.getProperty("user.home") + "/Documents/VOUCHERS_VENDEDOR";
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                //POR SI LA CARPETA NO EXISTE
                carpeta.mkdirs();
            }

            //NOMBRE DEL ARCHIVO
            String ruta = rutaCarpeta + "/voucher_" + idVenta + ".pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            doc.open();

            // FUENTES A UTILIZAR
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font negrita = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            // ENCABEZADO EMPRESA
            Paragraph datosEmp = new Paragraph(
                conf.getNombre() + "\n" +
                "RUC: " + conf.getRuc() + "\n" +
                "Dirección: " + conf.getDireccion() + "\n" +
                "Celular: " + conf.getCelular() + "\n",
                negrita
            );
            datosEmp.setAlignment(Element.ALIGN_CENTER);
            doc.add(datosEmp);

            doc.add(new Paragraph("--------------------------------------------------------------------------------------------------------", normal));

            //TITULO Y NUMERO DE VOUCHER
            Paragraph titulo = new Paragraph("VOUCHER DE VENTA", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            Paragraph numero = new Paragraph("N° de Comprobante: " + idVenta, normal);
            numero.setAlignment(Element.ALIGN_CENTER);
            doc.add(numero);
            doc.add(new Paragraph(" "));

            //DATOS DEL CLIENTE
            doc.add(new Paragraph("Cliente: " + txtNombreClienteV.getText(), normal));
            doc.add(new Paragraph("DNI: " + txtDniClienteV.getText(), normal));
            doc.add(new Paragraph("Fecha: " + new java.util.Date().toString(), normal));
            doc.add(new Paragraph(" "));

            //TABLA DE PRODUCTOS
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.addCell("Código");
            table.addCell("Nombre");
            table.addCell("Cant");
            table.addCell("Precio");
            table.addCell("Subtotal");

            double total = 0.0;

            for (int i = 0; i < TablaV.getRowCount(); i++) {
                table.addCell(TablaV.getValueAt(i, 0).toString());
                table.addCell(TablaV.getValueAt(i, 1).toString());
                table.addCell(TablaV.getValueAt(i, 4).toString());
                table.addCell(TablaV.getValueAt(i, 5).toString());
                table.addCell(TablaV.getValueAt(i, 6).toString());

                total += Double.parseDouble(TablaV.getValueAt(i, 6).toString());
            }

            doc.add(table);
            doc.add(new Paragraph(" "));

            //CALCULAR IGV, SUBTOTAL Y TOTAL
            double subtotal = total / 1.18;
            double igv = total - subtotal;

            Paragraph pSubtotal = new Paragraph("Subtotal: S/ " + String.format("%.2f", subtotal), normal);
            Paragraph pIgv = new Paragraph("IGV (18%): S/ " + String.format("%.2f", igv), normal);
            Paragraph pTotal = new Paragraph("TOTAL A PAGAR: S/ " + String.format("%.2f", total),
                                              new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));

            pSubtotal.setAlignment(Element.ALIGN_RIGHT);
            pIgv.setAlignment(Element.ALIGN_RIGHT);
            pTotal.setAlignment(Element.ALIGN_RIGHT);

            doc.add(pSubtotal);
            doc.add(pIgv);
            doc.add(pTotal);

            doc.add(new Paragraph("--------------------------------------------------------------------------------------------------------", normal));
            doc.add(new Paragraph(" "));

            //MENSAJE FINAL
            Paragraph mensajeFinal = new Paragraph(conf.getMensaje(), normal);
            mensajeFinal.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensajeFinal);

            Paragraph gracias = new Paragraph("¡Gracias por su compra!", normal);
            gracias.setAlignment(Element.ALIGN_CENTER);
            doc.add(gracias);

            doc.close();

            JOptionPane.showMessageDialog(null, 
                "Voucher generado con éxito:\n" + ruta,
                "Voucher creado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al generar PDF:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //CLIENTES
    private void ListarCliente() {
        List<Clientes> ListaCli = DAOcli.ListarClientes(); 
        DefaultTableModel modelo = (DefaultTableModel) TablaC.getModel();
        modelo.setRowCount(0); 

        Object[] fila = new Object[7];
        for (Clientes cl : ListaCli) {
            fila[0] = cl.getId();
            fila[1] = cl.getDocumento();
            fila[2] = cl.getNombre();
            fila[3] = cl.getCelular();
            fila[4] = cl.getDireccion();
            fila[5] = cl.getCorreo();
            fila[6] = cl.getEstado();
            modelo.addRow(fila);
        }
        TablaC.setModel(modelo);
    }
    private void LimpiarCliente() {
        txtDniC.setText("");
        txtNombreC.setText("");
        txtCelularC.setText("");
        txtDireccionC.setText("");
        txtCorreoC.setText("");
        cbxEstadoC.setSelectedIndex(0);

        txtDniC.requestFocus();
    }
    private void LimpiarTablaC() {
        DefaultTableModel modelo = (DefaultTableModel) TablaC.getModel();
        modelo.setRowCount(0);
    }
    //PRODUCTO
    private void ListarProducto() {
        List<Productos> ListaPro = DAOpro.ListarProductos();
        DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
        modelo.setRowCount(0);

        Object[] fila = new Object[10];
        for (Productos pr : ListaPro) {
            fila[0] = pr.getId();
            fila[1] = pr.getCodigo();
            fila[2] = pr.getNombre();
            fila[3] = pr.getDescripcion();
            fila[4] = pr.getTipo_hielo();
            fila[5] = pr.getPeso();
            fila[6] = pr.getPrecio();
            fila[7] = pr.getStock();
            fila[8] = pr.getFecha_registro();
            fila[9] = pr.getEstado();
            modelo.addRow(fila);
        }
        TablaP.setModel(modelo);
    }
    private void LimpiarProducto() {
        txtCodigoP.setText("");
        txtNombreP.setText("");
        txtDescripcionP.setText("");
        cbxTipoP.setSelectedIndex(0);
        txtPesoP.setText("");
        txtPrecioP.setText("");
        txtStockP.setText("");
        txtFechaRegistroP.setText("");
        cbxEstadoP.setSelectedIndex(0);
    }
    //PROVEEDOR
    private void ListarProveedor() {
        List<Proveedores> ListaPro = DAOprov.ListarProveedores();
        DefaultTableModel modelo = (DefaultTableModel) TablaPro.getModel();
        modelo.setRowCount(0);

        Object[] fila = new Object[8];
        for (Proveedores pr : ListaPro) {
            fila[0] = pr.getId();
            fila[1] = pr.getCodigo();
            fila[2] = pr.getNombre();
            fila[3] = pr.getRuc();
            fila[4] = pr.getDireccion();
            fila[5] = pr.getCelular();
            fila[6] = pr.getCorreo();
            fila[7] = pr.getEstado();
            modelo.addRow(fila);
        }
        TablaPro.setModel(modelo);
    }
    private void LimpiarProveedor() {
        txtCodigoPro.setText("");
        txtNombrePro.setText("");
        txtRucPro.setText("");
        txtDireccionPro.setText("");
        txtCelularPro.setText("");
        txtCorreoPro.setText("");
        cbxEstadoPro.setSelectedIndex(0);
    }
    //CONFIGURACION
    private void CargarDatosE(){
        conf = DAOconf.ObtenerDatosE();
        if(conf != null){
            txtRucE.setText(String.valueOf(conf.getRuc()));
            txtNombreE.setText(conf.getNombre());
            txtDireccionE.setText(conf.getDireccion());
            txtCelularE.setText(String.valueOf(conf.getCelular()));
            txtMensajeE.setText(conf.getMensaje());
        }
    }
    //ADMINISTRADOR
    private void ListarUsuario(){
        //LA TABLA SE BLOQUEA
        TablaAdministracion.setDefaultEditor(Object.class, null);
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("USUARIO");
        modelo.addColumn("CONTRASEÑA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CORREO");
        modelo.addColumn("ROL");
        
        DAO_Usuarios dao = new DAO_Usuarios();
        List<Usuarios> lista = dao.listarUsuarios();

        for (Usuarios u : lista) {
            Object[] fila = new Object[6];
            fila[0] = u.getId();
            fila[1] = u.getUsuario();
            fila[2] = u.getContrasena();
            fila[3] = u.getNombre();
            fila[4] = u.getCorreo();
            fila[5] = u.getRol();
            modelo.addRow(fila);
        }

        TablaAdministracion.setModel(modelo);
    }
    private void LimpiarUsuario(){
        txtUsuarioA.setText("");
        txtContrasenaA.setText("");
        txtNombreA.setText("");
        txtCorreoA.setText("");
        cbxRolA.setSelectedIndex(-1);
    }
    
}
