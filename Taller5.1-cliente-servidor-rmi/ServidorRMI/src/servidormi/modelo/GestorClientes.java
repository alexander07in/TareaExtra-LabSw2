package servidormi.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author libardo
 */
public class GestorClientes  implements Serializable{

    private ArrayList<Cliente> listado;

    public GestorClientes() {
        listado = new ArrayList();
        inicializarDatos();      
    }

    //Completar
    public void inicializarDatos() {
        
        listado.add(new Cliente("98000001", "Sara", "Narvaez", "01/02/1998",  "andrea@hotmail.com", "Femenino"));
        listado.add(new Cliente("98000002", "Mauricio", "Pantoja", "01/02/1976", "libardo@gmail.com", "Masculino"));  
    }

    public ArrayList<Cliente> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Cliente> listado) {
        this.listado = listado;
    }
}
