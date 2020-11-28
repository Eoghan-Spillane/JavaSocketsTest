import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4998);
        System.out.println("Connected");

        //Object to be sent must be created first

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", 2006));
        cars.add(new Car("Hyundai", 2011));
        cars.add(new Car("Toyota", 2003));
        cars.add(new Car("Toyota", 2007));

        objectOutputStream.writeObject(cars);

        System.out.println("Closing Socket");

        //Forces unsent data to be sent
        socket.close();
    }
}
