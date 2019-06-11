
package agenciaviajes.presentacion;

import servidormi.modelo.Cliente;
import agenciaviajes.negocio.GestorClientes;
import java.awt.event.ItemEvent;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import mvcf.AModel;
import mvcf.AView;

/**
 * Vista que representa un observer
 * @author Libardo, Julio, Ricardo
 */
public class GUIClientes extends javax.swing.JFrame implements AView {

   private String nombreServidor; 
   private GestorClientes miGestor;
    
    /**
     * Constructor
     */
    public GUIClientes() {
        initComponents();
        miGestor = new GestorClientes();
        setSize(870, 400);
        setLocation(50, 50);
        cambiarLista();
        inicializarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        pnlNorte = new javax.swing.JPanel();
        mijComboBox = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        jscrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Clientes");

        mijComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Socket", "RMI", " " }));
        mijComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mijComboBoxItemStateChanged(evt);
            }
        });
        mijComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mijComboBoxActionPerformed(evt);
            }
        });
        pnlNorte.add(mijComboBox);

        btnBuscar.setText("Buscar Clientes");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlNorte.add(btnBuscar);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.NORTH);

        pnlCentro.setBorder(javax.swing.BorderFactory.createTitledBorder("Plan:"));
        pnlCentro.setLayout(new java.awt.BorderLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jscrollPane1.setViewportView(tblClientes);

        pnlCentro.add(jscrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSur.add(btnCerrar);

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(mijComboBox.getSelectedItem().toString().equals("RMI"))
        {
            nombreServidor = "agenciaviajes.acceso.ServidorRMI";
        }
        else if(mijComboBox.getSelectedItem().toString().equals("Socket"))
        {
            nombreServidor = "agenciaviajes.acceso.ServidorSocket";
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mijComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mijComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mijComboBoxActionPerformed

    private void mijComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mijComboBoxItemStateChanged
       // TODO add your handling code here:
       switch (evt.getStateChange()) {
           case ItemEvent.SELECTED:
               String seleccion = mijComboBox.getSelectedItem().toString();
               if(seleccion.equals("RMI"))
               {
                   nombreServidor = "agenciaviajes.acceso.ServidorRMI";
               }
               else if(seleccion.equals("Socket"))
               {
                   nombreServidor = "agenciaviajes.acceso.ServidorSocket";
               }  break;
           case ItemEvent.DESELECTED:
               break;
           default:
              
               break;
       }
    }//GEN-LAST:event_mijComboBoxItemStateChanged

    public void cambiarLista()
    {
        String[] servidores = {"Opciones: ", "RMI", "Socket"};
        mijComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(servidores));                  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jscrollPane1;
    private javax.swing.JComboBox<String> mijComboBox;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables

    
    public void inicializarTabla() {

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nombres", "Apellidos", "Email", "Sexo", "Edad"
                }
        ));
    }
    
    @Override
    public void actualizar(AModel amodel) {
        GestorClientes gestor = (GestorClientes) amodel;
        ArrayList<Cliente> listado = gestor.getClientes();
        llenarTabla(listado);
    }
   
    private void llenarTabla(ArrayList<Cliente> clientes) {
        this.inicializarTabla();
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

        Object rowData[] = new Object[6];
        for (Cliente cli : clientes) {
            rowData[0] = cli.getId();
            rowData[1] = cli.getNombres();
            rowData[2] = cli.getApellidos();
            rowData[3] = cli.getEmail();
            rowData[4] = cli.getSexo();
            rowData[5] = "" + cli.calcularEdad();
            model.addRow(rowData);
        }
    }
    
    public JButton getBtnBuscar(){  
       return btnBuscar;
    }
    
    public String obtenerNombreServidor() {
        return nombreServidor;
    }
        
}