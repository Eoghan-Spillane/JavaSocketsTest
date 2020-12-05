package rmiClient;

import rmiShared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private UpperCaseServer server;

    public RMIClient(){};

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (UpperCaseServer) registry.lookup("Server");
    }

    public String toUpperCase(String arg) throws RemoteException {
        String result = null;
        try{
            result = server.toUpperCase(arg);
        } catch (RemoteException e){
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }
}
