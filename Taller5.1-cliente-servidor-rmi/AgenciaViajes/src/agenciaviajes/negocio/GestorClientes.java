package agenciaviajes.negocio;

import agenciaviajes.acceso.IServicio;
import agenciaviajes.presentacion.GUIClientes;
import java.rmi.RemoteException;
import mvcf.AModel;

import java.util.ArrayList;
import servidormi.modelo.Cliente;


/**
 * Representa el modelo (Observable) de datos Cuando hay cambios en el estado,
 * notifica a todas sus vistas (observadores)
 *
 * @author Julio, Libardo, Ricardo
 */
public class GestorClientes extends AModel {

    private IServicio servidor;
    private ArrayList<Cliente> clientes;
    private int totalHombres;
    private int totalMujeres;

    public GestorClientes() {
       
    }
    
    //Completar
    public void listarClientes(String nombreServidor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        Fabrica fabrica = new Fabrica();
        servidor = fabrica.getServidor(nombreServidor);
        clientes = pasarVectorToArray(servidor.consultarClientesServicio());
        
        for(int i=0; i<clientes.size(); i++) {
            if(clientes.get(i).getSexo().equals("Masculino"))
                totalHombres++;
            else if((clientes.get(i).getSexo().equals("Femenino")))
                totalMujeres++;
        }
        this.notificar();
    }
    
    private ArrayList<Cliente> pasarVectorToArray(Cliente[] misClientes)
    {
        ArrayList<Cliente> arrayClientes = new ArrayList<>();
        for(int i=0; i<misClientes.length; i++)
        {
            arrayClientes.add(misClientes[i]);
        }
        return arrayClientes;
    }

    public int getTotalHombres() {
        return totalHombres;
    }

    public int getTotalMujeres() {
        return totalMujeres;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

 
}