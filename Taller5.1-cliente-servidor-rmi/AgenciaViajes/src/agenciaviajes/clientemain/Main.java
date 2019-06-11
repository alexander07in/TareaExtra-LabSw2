package agenciaviajes.clientemain;
import java.rmi.RemoteException;
import servidorrmi.servicios.InterfazRemota;

/**
 *
 * @author libardo
 */
public class Main {

    
    private static InterfazRemota objRemoto;
    
    public static void main(String[] args) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        RunMVC mainRunMVC = new RunMVC();
        
    }
 

}
