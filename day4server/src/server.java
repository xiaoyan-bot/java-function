import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        System.out.println("服务端启动，等待连接");
        System.out.println("----------------");

        //等待客户端连接
        Socket socket=serverSocket.accept();//连接之后才会执行下一句
        System.out.println("客户端已连接");

        //读取客户端数据
        InputStream is=socket.getInputStream();
        byte[] b=new byte[1024];
        int len;
        while ((len=is.read(b))!=-1){
            String str=new String(b,0,len);
            System.out.println(str);
        }
        socket.close();
        serverSocket.close();
    }
}
