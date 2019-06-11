/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorrmi.servicios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import servidormi.modelo.Cliente;
import servidormi.modelo.GestorClientes;

/**
 * 
 * @author Alexander Inagan
 */
public class InterfazImpl extends UnicastRemoteObject implements InterfazRemota {

    GestorClientes miGestor;
    
    public InterfazImpl() throws RemoteException {
        super();
        miGestor = new GestorClientes();
    }
    @Override
    public Cliente[] consultarClientesServicio() throws RemoteException {
        Cliente[] listaCliente = new Cliente[miGestor.getListado().size()];
        ArrayList<Cliente> arrayCliente = miGestor.getListado();
        for(int i=0; i<arrayCliente.size(); i++)
        {
            listaCliente[i] = arrayCliente.get(i);
        }
        
        return listaCliente;
    }
}