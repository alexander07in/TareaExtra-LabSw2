package servidorrmi.servicios;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidormi.modelo.Cliente;

/**
 *
 * @author Libardo Pantoja
 */
public interface InterfazRemota extends Remote {

    public Cliente[] consultarClientesServicio() throws RemoteException;

}
