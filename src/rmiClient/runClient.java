package rmiClient;
//https://www.youtube.com/watch?v=FX5hR-np-sg
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class runClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIClient client = new RMIClient();
        client.startClient();

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Input >");
            String line = in.nextLine();

            if(line.equalsIgnoreCase("exit")) {
                break;
            }

            String result = null;
            try {
                result = client.toUpperCase(line);
                System.out.println("Result > " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
