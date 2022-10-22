import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
    public static void main (String[] args) throws IOException {
        Socket s = new Socket();
        s.connect(new InetSocketAddress("alunos.di.uevora.pt",9000));
    }
}