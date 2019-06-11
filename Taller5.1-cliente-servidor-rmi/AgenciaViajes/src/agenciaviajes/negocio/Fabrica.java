package agenciaviajes.negocio;

import agenciaviajes.acceso.IServicio;

/**
 * 
 * @author Alexander Inagan
 */
public class Fabrica {

    public IServicio getServidor(String nombreServidor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        if(nombreServidor != null)
        {
            IServicio miInterfaz = (IServicio) Class.forName(nombreServidor).newInstance();
        return miInterfaz;
        }
        return null;
    }

}
