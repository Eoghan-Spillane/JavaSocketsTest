import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// https://gist.github.com/chatton/14110d2550126b12c0254501dde73616


public class Client1 {

    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost", 4999);
            System.out.println("Connected");

            //Object to be sent must be created first

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Kia", 2006));
            cars.add(new Car("SangYong", 2011));
            cars.add(new Car("Samsung", 2003));
            cars.add(new Car("Mitsubishi", 2003));

            objectOutputStream.writeObject(cars);

            System.out.println("Closing Socket");

            //Forces unsent data to be sent
            socket.close();
        }catch(IOException e){
            System.out.println("No Response From Server");
        }
    }
}
