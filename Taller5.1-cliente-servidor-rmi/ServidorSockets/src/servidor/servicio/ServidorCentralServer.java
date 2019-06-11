package servidor.servicio;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.negocio.Cliente;
import servidor.negocio.GestorClientes;
import servidor.negocio.GestorPlanes;
import servidor.utils.Utilidades;



public class ServidorCentralServer implements Runnable {

    private final GestorClientes gestorClientes;
    private final GestorPlanes gestorPlanes;

    private static ServerSocket ssock;
    private static Socket socket;

    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5000;

    /**
     * Constructor
     */
    public ServidorCentralServer() throws ParseException {
        gestorClientes = new GestorClientes();
        gestorPlanes = new GestorPlanes();
    }

    /**
     * Logica completa del servidor
     */
    public void iniciar() throws ParseException {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() throws ParseException {
        new Thread(new ServidorCentralServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Servidor socket escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente Conectado...");
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa al estilo
     * "consultarCiudadano,983932814"
     */
    private void decodificarPeticion(String peticion) {
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Segun el protocolo decide qué accion invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) {
        switch (accion) {
            case "consultarClientes":
                ArrayList<Cliente> clientes = gestorClientes.getListado();
                if (clientes == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(serializarClientes(clientes));
                }
                break;

        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    private String serializarClientes(ArrayList<Cliente> listado) {
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        
        for (Cliente cli : listado) {
            gsonObj = parseToJSONCliente(cli);
            array.add(gsonObj);
        }
        System.out.println("Clientes json serializado: " + array.toString());
        return array.toString();
    }
    
    /**
    * Convierte el objeto Cliente a json
    *
    * @param Cliente Objeto Cliente
    * @return Objeto json
    */
    private JsonObject parseToJSONCliente(Cliente objCliente)
    {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("id", objCliente.getId());
        jsonobj.addProperty("nombres", objCliente.getNombres());
        jsonobj.addProperty("apellidos", objCliente.getApellidos());
        jsonobj.addProperty("fechaNac", Utilidades.formatoFecha(objCliente.getFechaNac()));
        jsonobj.addProperty("sexo", objCliente.getSexo());
        jsonobj.addProperty("email", objCliente.getEmail());
        
        return jsonobj;
    }
}