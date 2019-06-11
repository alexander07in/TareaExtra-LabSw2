
package servidorrmi.servicios;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class Servidor {

    
    private static final int PUERTO = 1100; //Si cambias aquÃ­ el puerto, recuerda cambiarlo en el cliente

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        String direccion = "localhost";
        InterfazImpl objRemoto = new InterfazImpl();
        
        try
        {
            UtilidadesRegistros.arrancar(PUERTO);
            UtilidadesRegistros.registrarObjetoRemoto(objRemoto, direccion, PUERTO, "objUsuario");
        }
        catch(Exception e) {
            System.err.println("No fue posible arrancar el puerto o registrar el objeto remoto." + e.getMessage());
        }
        
    }
}