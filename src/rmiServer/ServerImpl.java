package rmiServer;
//https://www.youtube.com/watch?v=FX5hR-np-sg


import rmiShared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String toUpperCase(String str) throws RemoteException {
        return str.toUpperCase();
    }

}
