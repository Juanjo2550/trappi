
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;
import javax.swing.JOptionPane;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cristhian.munoz
 */
public class RegistrarVehiculo extends javax.swing.JPanel {

    ServicioDbVehiculo servicioVH = new ServicioDbVehiculo();
    
    public RegistrarVehiculo() {
        initComponents();
        txtId.setEnabled(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        lblDireccion = new javax.swing.JLabel();
        cboTipoVehiculo = new javax.swing.JComboBox<>();
        lvlTelefono = new javax.swing.JLabel();
        txtKilometraje = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));

        jPanel9.setBackground(new java.awt.Color(61, 57, 57));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel9.setForeground(new java.awt.Color(61, 57, 57));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro de vehículo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCelular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCelular.setText("ID:");

        txtId.setEnabled(false);

        lblNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombres.setText("Matrícula:");

        txtMatricula.setEnabled(false);

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellidos.setText("Estado:");

        cboEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado", "Inabilitado", "En Espera" }));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setText("Tipo Vehículo:");

        cboTipoVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automovil", "Motocicleta" }));
        cboTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoVehiculoActionPerformed(evt);
            }
        });

        lvlTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lvlTelefono.setText("Kilometraje:");

        txtKilometraje.setEnabled(false);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lvlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMatricula)
                                .addComponent(txtKilometraje, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboTipoVehiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, 520, Short.MAX_VALUE)
                                .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoVehiculoActionPerformed

    }//GEN-LAST:event_cboTipoVehiculoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiarGui();
        desactivarBtn();
        desactivarTxt();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        //-------------- validar
        strErrores+=verificarMatricula(txtMatricula.getText());
        //strErrores+=verificarKilometraje(txtKilometraje.getText());
        if(!strErrores.equals(""))
        {
            strErrores="Errores existentes:\n"+strErrores;
            JOptionPane.showMessageDialog(null, strErrores , "Error al Registar Cliente" , JOptionPane.ERROR_MESSAGE);
            strErrores="";
            return;
        }else {
            //Crear Instancia temporal de vehiculo
            Vehiculo aux= new Vehiculo();
            aux.setMatricula(txtMatricula.getText());
            aux.setKilometraje(Integer.parseInt(txtKilometraje.getText()));
            aux.setID(Integer.parseInt(txtId.getText()));
            if (cboEstado.getSelectedIndex()==0){
                aux.setEstado(new Habilitado(aux));
            }if (cboEstado.getSelectedIndex()==1){
                aux.setEstado(new Inhabilitado(aux));
            }if (cboEstado.getSelectedIndex()==2){
                aux.setEstado(new EnEspera(aux));
            }
            if (cboTipoVehiculo.getSelectedIndex()==0){
                aux.setTipo("Automovil");
            }if (cboTipoVehiculo.getSelectedIndex()==1){
                aux.setTipo("Motocicleta");;
            }

            //Instanciar un Vehiculo para su insercion en la DB

            try {
                servicioVH.insertar(aux);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, null, "Error al Registar Cliente" , JOptionPane.ERROR_MESSAGE);
            }
        }

        limpiarGui();
        strErrores=" ";
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarGui();
        cboEstado.setEnabled(true);
        cboTipoVehiculo.setEnabled(true);
        activarTxt();
        btnRegistrar.setEnabled(true);
        try {
            txtId.setText(Integer.toString(servicioVH.ObtenerMaxId()+1));
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void limpiarGui()
    {
       
        txtMatricula.setText("");
        txtKilometraje.setText("");
        txtId.setText("");
       
    }
    private void activarTxt()
    {
        
        txtMatricula.setEnabled(true);
        txtKilometraje.setEnabled(true);
        
        
    }
    
    private void desactivarTxt()
    {
        
        txtMatricula.setEnabled(false);
        txtKilometraje.setEnabled(false);
       
        
    }
    
    private void desactivarBtn()
    {
        btnRegistrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        
    }
    public String verificarMatricula(String matricula)
	{
            boolean error1= true;
            String error = "";
            String patron = ("^[A-Z]{3}-[0-9]{3,4}$");
            
            if(matricula.equals(""))
                error += "Matricula: Campo vacío.\n";
            else
                if (!(matricula.matches(patron)))
                    error += "Matricula: caracteres incorrectos.\n";
            return error;
        }
     public static String verificarKilometraje(String telefono)
	{
		String error = "";
		String patron = ("^[0-9]{1,6}$");
                
		if (telefono.equals(""))
			error += "Kilometraje: Campo vacio.\n";
		else
		{
			if (!(telefono.matches(patron)))
				error += "Kilometraje: Caracteres no válidos\n";
                                error += "Hasta un kilometraje de 999999\n";
                        
		}
		return error;
	}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboTipoVehiculo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lvlTelefono;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKilometraje;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
    private String strErrores="";
}