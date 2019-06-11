package servidor.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Alexander Inagan
 */

public class GestorClientes {

    private ArrayList<Cliente> listado;

    public GestorClientes() throws ParseException {
        listado = new ArrayList();
        this.inicializar();
    }

    // Completar
    public void inicializar() throws ParseException {
        
        try
        {
            listado.add(new Cliente("98000001", "Andrea", "Sanchez", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1998"), "Femenino", "andrea@gmail.com"));
            listado.add(new Cliente("98000002", "Libardo", "Pantoja", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1976"), "Masculino", "libardo@gmail.com"));
            listado.add(new Cliente("98000003", "Carlos", "Pantoja", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1976"), "Masculino", "carlos@gmail.com"));
            listado.add(new Cliente("98000004", "Fernanda", "Arevalo", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1975"), "Femenino", "fercha@hotmail.com"));
            listado.add(new Cliente("98000005", "Manuel", "Perez", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"), "Masculino", "fer@hotmail.com"));
            listado.add(new Cliente("98000006", "Alejandro", "Mosquera",  new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"), "Masculino", "fer@hotmail.com"));
            listado.add(new Cliente("98000007", "Cesar", "Gutierres Sanchez",  new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"), "Masculino", "fer@hotmail.com"));
            listado.add(new Cliente("98000008", "Julio", "Bravo Bravo", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"),"Masculino", "fer@hotmail.com"));
            listado.add(new Cliente("98000009", "Alberto", "Mendez Bravo", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"),"Masculino", "fer@hotmail.com"));
            listado.add(new Cliente("98000010", "Alexander", "Ponce Yepes", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975"), "Masculino", "fer@hotmail.com"));
        }
        catch (ParseException ex) 
        {
            Logger.getLogger(GestorClientes.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }

    public ArrayList<Cliente> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Cliente> listado) {
        this.listado = listado;
    } 
}