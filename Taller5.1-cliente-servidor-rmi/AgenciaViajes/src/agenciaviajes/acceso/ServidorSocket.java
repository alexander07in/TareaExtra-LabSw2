package agenciaviajes.acceso;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidormi.modelo.Cliente;

/**
 *
 * @author ahurtado, wpantoja, rzambran
 */
public class ServidorSocket implements IServicio {

    private Socket socket = null;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private final String IP_SERVIDOR = "localhost";
    private final int PUERTO = 5000;
    
    // Completar
    @Override
    public Cliente[] consultarClientesServicio() {
        String arrayJson;
        String accion = "consultarClientes";
        Cliente[] listaClientes = null;
        
        try
        {
            conectar(IP_SERVIDOR, PUERTO);
            arrayJson = consultarServicio(accion);
            cerrarFlujos();
            desconectar();
            
            if(!arrayJson.equals("NO_ENCONTRADO"))
            {
                //Lo encontro
                listaClientes = deserializarMisClientes(arrayJson);
            }
        }
        catch(IOException ex)
        {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }
 
    private Cliente[] deserializarMisClientes(String arrayJsonSerializado)
    {
        Cliente[] misClientes = new Gson().fromJson(arrayJsonSerializado, Cliente[].class);
        return misClientes;
    }
    
    private String consultarServicio(String servicio) throws IOException {
        
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        //Usando Protocolo de Comunicación
        salidaDecorada.println(servicio);
        if(entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        
        return respuesta;
    }  
    
    private void cerrarFlujos() {
        salidaDecorada.close();
        entradaDecorada.close();
    }

    private void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void conectar(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Conectado");
    }

}
