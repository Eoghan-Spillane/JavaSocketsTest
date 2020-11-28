import java.net.*;
import java.io.*;

// https://gist.github.com/chatton/14110d2550126b12c0254501dde73616


public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        System.out.println("Connected");

        Car ford = new Car("ford", 2006);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(ford);

        System.out.println("Closing Socket");

        //Forces unsent data to be sent
        socket.close();
    }
}
