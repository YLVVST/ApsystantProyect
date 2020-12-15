/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataBase.Connect;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YLVVST
 */
public class QueryUI extends javax.swing.JFrame
{

    int contador = 1;
    int[] indice = new int[12];
    int answers = 0;
    String[] respuesta = new String[12];
    private String sexo, nombre, edad, puntaje, resultado;
    Connect cc = new Connect();
    Connection cn = cc.connect();

    public QueryUI()
    {
        initComponents();
        Image imagen = new ImageIcon(getClass().getResource("/Resources/app_logo.png")).getImage();
        this.setIconImage(imagen);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        modeloTabla();
        mostrarDatos("");
    }
    
    public void modeloTabla()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("Puntaje");
        jTableRegistros.setModel(modelo);
    }

    void mostrarDatos(String valor)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("Puntaje");
        jTableRegistros.setModel(modelo);
        String sql = "";
        if (valor.equals(""))
        {
            sql = "SELECT * FROM Personas";
        }
        else
        {
            sql = "SELECT * FROM Personas WHERE nombre='" + valor + "'";
        }

        String[] datos = new String[6];
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                modelo.addRow(datos);
            }
            jTableRegistros.setModel(modelo);
        }
        catch (SQLException ex)
        {

        }
    }

    public void busquedaRegistros(String busqueda)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql ="";
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("Puntaje");
        jTableRegistros.setModel(modelo);

        String filtro = "" + busqueda + "_%";
        sql = "SELECT * FROM Personas WHERE Nombre LIKE " + '"' + filtro + '"';
        String[] datos = new String[6];
        
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                modelo.addRow(datos);
            }
            this.jTableRegistros.setModel(modelo);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(QueryUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jLabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/close.png"))); // NOI18N
        jButtonClose.setToolTipText("Cerrar");
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClose.setFocusPainted(false);
        jButtonClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 40, 40));

        jButtonMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize.png"))); // NOI18N
        jButtonMinimize.setToolTipText("Minimizar");
        jButtonMinimize.setBorderPainted(false);
        jButtonMinimize.setContentAreaFilled(false);
        jButtonMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMinimize.setFocusPainted(false);
        jButtonMinimize.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonMinimizeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 40, 40));

        jScrollPane1.setFont(new java.awt.Font("Futura Lt BT", 0, 20)); // NOI18N

        jTableRegistros.setFont(new java.awt.Font("Futura Lt BT", 0, 18)); // NOI18N
        jTableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRegistros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 1280, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/label_title2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jTextFieldBusqueda.setFont(new java.awt.Font("Futura Lt BT", 0, 32)); // NOI18N
        jTextFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextFieldBusquedaKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 540, 80));

        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/update_button.png"))); // NOI18N
        jButtonUpdate.setToolTipText("Actualizar");
        jButtonUpdate.setBorderPainted(false);
        jButtonUpdate.setContentAreaFilled(false);
        jButtonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUpdate.setFocusPainted(false);
        jButtonUpdate.setFocusable(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 80, 80));

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete_button.png"))); // NOI18N
        jButtonDelete.setToolTipText("Borrar Seleccionado");
        jButtonDelete.setBorderPainted(false);
        jButtonDelete.setContentAreaFilled(false);
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setFocusable(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 80, 80));

        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home_button.png"))); // NOI18N
        jButtonHome.setToolTipText("Regresar a Principal");
        jButtonHome.setBorderPainted(false);
        jButtonHome.setContentAreaFilled(false);
        jButtonHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHome.setFocusPainted(false);
        jButtonHome.setFocusable(false);
        jButtonHome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonHomeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 80, 80));

        jLabelWallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/wallpaper2.png"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCloseActionPerformed
    {//GEN-HEADEREND:event_jButtonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonMinimizeActionPerformed
    {//GEN-HEADEREND:event_jButtonMinimizeActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizeActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonUpdateActionPerformed
    {//GEN-HEADEREND:event_jButtonUpdateActionPerformed
        String texto="";
        mostrarDatos(texto);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteActionPerformed
    {//GEN-HEADEREND:event_jButtonDeleteActionPerformed
        int fila = jTableRegistros.getSelectedRow();

        if (fila >= 0)
        {
            String valor = "";
            valor = jTableRegistros.getValueAt(fila, 0).toString();

            try
            {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM Personas WHERE Id='" + valor + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Eliminado", "CORRECTO", 1);
                jTextFieldBusqueda.setText(" ");
                mostrarDatos("");
            }
            catch (HeadlessException | SQLException e)
            {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "WARNING", 2);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "WARNING", 2);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHomeActionPerformed
    {//GEN-HEADEREND:event_jButtonHomeActionPerformed
        MainUI window = new MainUI();
        this.dispose();
        window.setVisible(true);
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jTextFieldBusquedaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldBusquedaKeyReleased
    {//GEN-HEADEREND:event_jTextFieldBusquedaKeyReleased
        String buscar = jTextFieldBusqueda.getText();
        busquedaRegistros(buscar);
    }//GEN-LAST:event_jTextFieldBusquedaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainUI().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegistros;
    private javax.swing.JTextField jTextFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}