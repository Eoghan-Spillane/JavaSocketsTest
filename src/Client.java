import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// https://gist.github.com/chatton/14110d2550126b12c0254501dde73616


public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        System.out.println("Connected");

        //Object to be sent must be created first

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", 2006));
        cars.add(new Car("Hyundai", 2011));
        cars.add(new Car("Toyota", 2003));
        cars.add(new Car("Toyota", 2003));


        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(cars);

        System.out.println("Closing Socket");

        //Forces unsent data to be sent
        socket.close();
    }
}
