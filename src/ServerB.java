import java.net.*;
import java.io.*;
import java.util.List;

// https://gist.github.com/chatton/14110d2550126b12c0254501dde73616


public class ServerB implements Runnable{
    @Override
    public void run() {

        System.out.println("Server Started: B");

        try{
            ServerSocket serverSocket = new ServerSocket(4999);
            Socket socket = serverSocket.accept();

            System.out.println("\nClient Connected To B: " + socket);

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);



            //Variables must be created on the server for the incoming objects to be added to it.
            //noinspection unchecked
            List<Car> cars = (List<Car>) objectInputStream.readObject();
            System.out.println("Received [" + cars.size() + "] Cars");

            for (Car car : cars) {
                System.out.println(car.toString());
            }

            System.out.println("Closing Server B\n");
            serverSocket.close();
            socket.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.print("ERROR");
        }

    }
}
