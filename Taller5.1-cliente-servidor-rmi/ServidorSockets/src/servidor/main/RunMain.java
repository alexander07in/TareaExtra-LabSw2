package servidor.main;

import java.text.ParseException;
import servidor.servicio.ServidorCentralServer;

/**
 * 
 * @author Alexander Inagan
 */

public class RunMain {
    
    public static void main(String args[]) throws ParseException{
        ServidorCentralServer regSer = new ServidorCentralServer();
        regSer.iniciar();
    }
}
