package com.epn.trappi.gui.ecommerce.Interfaces;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.db.ecommerce.ListaCarrito;
import com.epn.trappi.gui.ecommerce.Diseño.TextPrompt;

import com.epn.trappi.gui.ecommerce.Ecommerce.CarritoDeCompras;
import com.epn.trappi.gui.ecommerce.Ecommerce.Factura;
import com.epn.trappi.gui.ecommerce.Ecommerce.Main;
import com.epn.trappi.gui.ecommerce.FacturaMostrar.FacturaFis;
import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.Inventario;
import com.epn.trappi.models.proveedores.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;

public class Comprar extends javax.swing.JFrame {

    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    public static CarritoDeCompras carrito = new CarritoDeCompras();
    String id1;
    String nombre1;
    String marca1;
    Double precio1;
    int cantidad1;

    public Comprar() {
        initComponents();
        this.setSize(1300, 690);
        this.setLocationRelativeTo(null);
        llenartabla();
        carrito.vaciarCarrito();
        jButtonagregar.setVisible(false);
        jButtoneliminar.setVisible(false);
        jt.setText(Main.cliente.Nombre);
        jt.setEditable(false);
        TextPrompt buscar = new TextPrompt("Busqueda", jTextFieldBuscar);
    }

    public void llenartabla() {

        //Controlador.inventario.
        Inventario inventario;
        try {
            inventario = new Inventario();
            inventario.getListaDeBienesNormales();
            ArrayList<Bien> bienes = inventario.getListaDeBienes().getListaBienes();
            DefaultTableModel productos = (DefaultTableModel) jTable1.getModel();
            String[] aux = new String[4];
            bienes.forEach(bien -> {
                if (bien.getCantidad() >= 1) {
                    aux[0] = bien.getNombre();
                    aux[1] = bien.getMarca();
                    aux[2] = String.valueOf(bien.getPrecio());
                    aux[3] = String.valueOf(bien.getCantidad());
                    productos.addRow(aux);
                }

            });
            jTable1.setModel(productos);
        } catch (IOException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
    
    public void buscar() {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
        ListaCarrito lc=new ListaCarrito();
        ArrayList<Bien> bienes = lc.buscar(jTextFieldBuscar.getText());
        DefaultTableModel productos = (DefaultTableModel) jTable1.getModel();
        String[] aux = new String[4];
        bienes.forEach(bien -> {
            if (bien.getCantidad() >= 1) {
                aux[0] = bien.getNombre();
                aux[1] = bien.getMarca();
                aux[2] = String.valueOf(bien.getPrecio());
                aux[3] = String.valueOf(bien.getCantidad());
                productos.addRow(aux);
            }
            
        });
        jTable1.setModel(productos);

       
    }
    
    
    
    
    
    
    
    
    
    
    

    public void obtenerproductodestock() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        nombre1 = ((String) modelo.getValueAt(jTable1.getSelectedRow(), 0));
        marca1 = ((String) modelo.getValueAt(jTable1.getSelectedRow(), 1));
        precio1 = Double.parseDouble((String) modelo.getValueAt(jTable1.getSelectedRow(), 2));
        cantidad1 = Integer.parseInt((String) modelo.getValueAt(jTable1.getSelectedRow(), 3));
    }

    
    
//    public void agregarAlcarrito(){
//    int cantidad = carrito.cantidadCompraProducto();
//        carrito.añadirProducto(nombre1, precio1, cantidad, marca1);
//        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
//        String[] aux = new String[3];
//        aux[0] = nombre1;
//        aux[1] = String.valueOf(precio1);
//        aux[2] = Integer.toString(cantidad);
//        modelo.addRow(aux);
//        jTable2.setModel(modelo);
//    }
//    
    public void agregarAlcarrito(){
    int cantidad = carrito.cantidadCompraProducto();
    boolean cantidaAdecuada = controlarCantidad(cantidad);
    if(cantidaAdecuada==true){
        
    
        carrito.añadirProducto(nombre1, precio1, cantidad, marca1);
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        String[] aux = new String[3];
        aux[0] = nombre1;
        aux[1] = String.valueOf(precio1);
        aux[2] = Integer.toString(cantidad);
        modelo.addRow(aux);
        jTable2.setModel(modelo);
    }
    else
    {
        JOptionPane.showMessageDialog(null,"No existe esa cantidad de productos");
    }
    }
    
    
    public boolean controlarCantidad(int cantidad2)
            
    {
        boolean bandera=false;
         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cantidad = (Integer.parseInt((String) modelo.getValueAt(jTable1.getSelectedRow(), 3)));
        if(cantidad2>cantidad)
        {
            bandera=false;
        }
        else
        {
            bandera=true;
        }
        return bandera;
    }
    
    public void confirmarcompra() throws ParseException{
     String salida = "";

        if (carrito.confirmarContenido() == true) {
            carrito.factura = new Factura(carrito.Productos);
            String nombre = Main.cliente.Nombre;
            String cedula = Main.cliente.Cedula;
            ArrayList<Producto> detalle = carrito.factura.Detalle;
            //ArrayList<Articulo> detalle = carrito.factura.Detalle;
            Double subtotal = carrito.factura.calcularSubTotal();
            Double iva = carrito.factura.calcularImpuestos();
            Double totalConDescuento = carrito.factura.calcularTotalConDescuento(Main.cliente.Cedula);
            Double descuento=carrito.factura.calcularTotal()-totalConDescuento;
            FacturaFis factu = new FacturaFis();
            Calendar fechaActual = new GregorianCalendar();
            int anoActual = fechaActual.get(Calendar.YEAR);
            int mesActual = fechaActual.get(Calendar.MONTH) + 1; 
            int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
            String date=diaActual+"/"+mesActual+"/"+anoActual;
            factu.cargarDatos(000, nombre, cedula, date, detalle, subtotal, iva,descuento, totalConDescuento);
            factu.setVisible(true);

            if (JOptionPane.showConfirmDialog(null, "¿Desea pagar?", "El proceso de pago empezará", JOptionPane.YES_NO_OPTION) == YES_OPTION) {
                TarjetaUsuario tarusu = new TarjetaUsuario();
                tarusu.setVisible(true);
                factu.setVisible(false);
                this.setVisible(false);
            }
        }
    }
    
    public void vaciarcarro(){
    DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jt = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButtonagregar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtoneliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setText("Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton2.setText("Comprar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton3.setText("Tarjetas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jt.setBackground(new java.awt.Color(0, 102, 102));
        jt.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jt.setForeground(new java.awt.Color(255, 255, 255));
        jt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton8.setText("Devolucion");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton9.setText("VIP");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(43, 43, 43))
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos disponibles");

        jButton5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Precio", "Cantidad"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Carrito de compras");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton6.setText("Confirmar carrito");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButtonagregar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonagregar.setText("Agregar");
        jButtonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonagregarActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton7.setText("Vaciar Carrito");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtoneliminar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtoneliminar.setText("Eliminar");
        jButtoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneliminarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/panelSuperiorComidasVariadasCortada.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_solotexto_resize.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel4)
                .addGap(78, 78, 78)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonagregar)
                                .addGap(150, 150, 150))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButtoneliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7)
                            .addComponent(jButtoneliminar))
                        .addGap(37, 37, 37))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CuentaCliente cuenta = new CuentaCliente();
        cuenta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Main.cliente.salirSistema();
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Metododepago mp = new Metododepago();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonagregarActionPerformed
        obtenerproductodestock();
        agregarAlcarrito();
    }//GEN-LAST:event_jButtonagregarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButtonagregar.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            confirmarcompra();
        } catch (ParseException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        carrito.vaciarCarrito();
        vaciarcarro();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        String nombre = ((String) modelo.getValueAt(jTable2.getSelectedRow(), 0));
        carrito.borrarProducto(nombre);
        modelo.removeRow(jTable2.getSelectedRow());
    }//GEN-LAST:event_jButtoneliminarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jButtoneliminar.setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DevolucionEcommerce devolucion=new DevolucionEcommerce();
        this.setVisible(false);
        devolucion.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
     buscar();
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ComprarVIP cv=new ComprarVIP();
        cv.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonagregar;
    private javax.swing.JButton jButtoneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jt;
    // End of variables declaration//GEN-END:variables
}
