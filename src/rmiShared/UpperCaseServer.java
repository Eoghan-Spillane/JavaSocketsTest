package rmiShared;
//https://www.youtube.com/watch?v=FX5hR-np-sg
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote{
    String toUpperCase(String str) throws RemoteException;
}
