import java.net.*;
import java.io.*;
import java.util.List;

// https://gist.github.com/chatton/14110d2550126b12c0254501dde73616


public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(4999);
        Socket socket = serverSocket.accept();

        System.out.println("Client Connected: " + socket);

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);



        //Variables must be created on the server for the incoming objects to be added to it.
        List<Car> cars = (List<Car>) objectInputStream.readObject();
        System.out.println("Received [" + cars.size() + "] Cars");

        for (Car car : cars) {
            System.out.println(car.toString());
        }

        System.out.println("Closing Sockets");
        serverSocket.close();
        socket.close();
    }
}
