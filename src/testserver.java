import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class testserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        System.out.println("客户端连接成功");
        InputStream inputStream = accept.getInputStream();
        byte[] b=new byte[1024];
        int len;
        while ((len=inputStream.read(b))!=-1){
            String str=new String(b,0,len);
            System.out.println(str);
            System.out.println("成功接收到你的消息");
        }
        serverSocket.close();
        accept.close();


    }
}
