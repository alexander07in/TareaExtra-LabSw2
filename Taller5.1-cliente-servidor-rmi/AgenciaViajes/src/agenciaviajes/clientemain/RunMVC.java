package agenciaviajes.clientemain;

import agenciaviajes.negocio.GestorClientes;
import agenciaviajes.presentacion.GUIClientesController;
import agenciaviajes.presentacion.GUIClientes;
import agenciaviajes.presentacion.GUIEstadisticaPorSexoGrafica;

/**
 * Es el pegamento de la aplición
 *
 * @author Libardo, Julio, Ricardo
 */
public class RunMVC {

    public RunMVC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        GestorClientes gestor = new GestorClientes();

        //PRIMERA VISTA
        GUIClientes view1 = new GUIClientes();
        gestor.addView(view1);
        GUIClientesController control = new GUIClientesController(gestor, view1);
        view1.setVisible(true);
        
//        //SEGUNDA VISTA
//        GUIEstadisticaPorSexoGrafica view3 = new GUIEstadisticaPorSexoGrafica(950,50);
//        gestor.addView(view3);        

        
  
        view1.getBtnBuscar().addActionListener(control);
        


    }
}
