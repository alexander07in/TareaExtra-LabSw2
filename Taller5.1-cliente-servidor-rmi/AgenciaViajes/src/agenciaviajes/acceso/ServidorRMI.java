package agenciaviajes.acceso;

import agenciaviajes.clientemain.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidormi.modelo.Cliente;
import servidorrmi.servicios.InterfazRemota;

/**
 *
 * @author libardo
 */
public class ServidorRMI implements IServicio {

    private static final String IP = "localhost"; // Puedes cambiar a localhost
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
    private InterfazRemota objRemoto;

    public ServidorRMI() {
        objRemoto = (InterfazRemota) UtilidadesRegistroC.obtenerObjetoRemoto(PUERTO, IP, "objUsuario");
    }

    @Override
    public Cliente[] consultarClientesServicio() {
        Cliente[] listaClientes = obetenerClientes();
        return listaClientes;
    }
    
    public Cliente[] obetenerClientes() {
        Cliente[] listaClientes = null;
        try {
            listaClientes = objRemoto.consultarClientesServicio();
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
    
}
