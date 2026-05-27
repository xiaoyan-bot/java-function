import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket socket=new Socket("127.0.0.1",8888);
        //获取网络输出流，用来发数据
        OutputStream outputStream = socket.getOutputStream();
        // // 3. 把字符串转字节数组，发送给服务端
        outputStream.write("hello world".getBytes());
        //关闭连接，释放资源
        socket.close();
    }
}
