package agenciaviajes.presentacion;

import agenciaviajes.negocio.GestorClientes;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;
import servidormi.modelo.Cliente;

/**
 *
 * @author Libardo, Ricardo, Julio
 */
public class GUIClientesController extends AActionController {

    private final GestorClientes gestor; // Modelo
    private final GUIClientes vista; //Vista

    public GUIClientesController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorClientes) myModel;
        this.vista = (GUIClientes) myView;
    }

    /**
     * Este método se invoca automáticamente desde GUICliente al presionar los
     * botones de accion
     *
     * @param e objeto tipo ActionEvent que indica qué boton se presionó
     */
    @Override
    public void actualizar(ActionEvent e) {
      
        try {
            gestor.listarClientes(vista.obtenerNombreServidor());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
