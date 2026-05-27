import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class testclient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.1.1.1",9999);


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是客户端，请求连接".getBytes());
        outputStream.flush();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        socket.close();




    }
}
