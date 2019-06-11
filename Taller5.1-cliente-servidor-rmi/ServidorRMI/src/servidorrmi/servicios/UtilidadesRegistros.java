package servidorrmi.servicios;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author Alexander Inagan
 */
public class UtilidadesRegistros {
    
    public static void arrancar(int puerto) throws RemoteException
    {
        try
        {
            Registry registro = LocateRegistry.getRegistry(puerto);
            String[] nombresLigados = registro.list();
            
            System.out.println("El registro se ha obtenido y se encuentra escuchando en el puerto: " + puerto);
            System.out.println("Nombres Registrados.");
            for(String nombreRegistrado : nombresLigados)
            {
                System.out.println("Nombre: " + nombreRegistrado);
            }
        }
        catch (RemoteException e)
        {
            System.out.println("El registro RMI no se localizÃ³ en el puerto: " + puerto);
            Registry registro = LocateRegistry.createRegistry(puerto);
	    System.out.println("El registro se ha creado en el puerto: " + puerto);         
        }   
    }
    
    public static void registrarObjetoRemoto(Remote objetoRemoto, String dirIp, int puerto, String nombreObjeto)
    {
        String URL = "rmi://"+dirIp+":"+puerto+"/"+nombreObjeto;
        try 
        {
            Naming.rebind(URL, objetoRemoto);
            System.out.println("Se realizo el registro con la direccion: " + URL);
            System.out.println("Esperando Peticiones...");
        } 
        catch (RemoteException e)
	{
            System.out.println("Error en el registro del objeto remoto");
	    e.printStackTrace();
	}
        catch (MalformedURLException e)
        {
            System.out.println("Error url invÃ¡lida");
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        
    }

}
