public class startServers {

    private static Object Server1 = new Server();
    private static Object Server2 = new Server2();

    public static void main(String[] arg){
        Thread server1 = new Thread((Runnable) Server1);
        Thread server2 = new Thread((Runnable) Server2);

        server1.start();
        server2.start();
    }
}
