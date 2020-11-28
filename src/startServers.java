public class startServers {

    // https://gist.github.com/chatton/14110d2550126b12c0254501dde73616
    private static final Object Server1 = new ServerA();
    private static final Object Server2 = new ServerB();

    public static void main(String[] arg){
        Thread server1 = new Thread((Runnable) Server1);
        Thread server2 = new Thread((Runnable) Server2);

        server1.start();
        server2.start();
    }

    public void restartServer1(){
        Thread server1 = new Thread((Runnable) Server1);
        server1.start();
    }

    public void restartServer2(){
        Thread server2 = new Thread((Runnable) Server2);
        server2.start();
    }
}
