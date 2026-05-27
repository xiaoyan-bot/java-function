import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


//Modbus 工控报文解析工具
public class ByteMsgParseDemo {
    //16进制转字节
    public static byte[] hexToBytes(String hexstr){
        byte[] bytes=new byte[hexstr.length()/2];

        for (int i = 0; i < hexstr.length() ; i+=2) {
            String s=hexstr.substring(i,i+2);
            int num=Integer.parseInt(s,16);
            bytes[i/2]=(byte) num;
        }
        return bytes;
    }
    //字节转16进制
    public static String bytesToHex(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }
    //大端转小端,modbus默认用的是小端
    public static int getShortFromHlBytes(byte[] bytes){
        return (bytes[1] & 0xFF) <<8|(bytes[0] & 0xFF);
    }

    //4字节转int
    public static int bytesToInt(byte[] bytes){
        return ByteBuffer.wrap(bytes).getInt();
    }


    //实战解析modbus 报文
    public static void parseModbusMsg(byte[] msg){
        if(msg.length<8){
            return;
        }

        //从站地址 第0位
        byte slaveAddr=msg[0];
        //功能码 第一位
        byte funCode=msg[1];
        //启示寄存器地址，第二到三位
        byte[] startAddrBytes={msg[2],msg[3]};
        //读取寄存器数量 4-5位
        byte[] numBytes={msg[4],msg[5]};
        int readNum=getShortFromHlBytes(numBytes);
        //CRC校验码，最后两位
        byte crcLow=msg[6];
        byte crcHigh=msg[7];

        System.out.println("======报文解析结果======");
        System.out.println("从站地址："+slaveAddr);
        System.out.println("功能码："+funCode);
        System.out.println("起始寄存器地址："+startAddrBytes);
        System.out.println("读取寄存器个数："+readNum);
        System.out.println("CRC低字节："+String.format("%02x",crcLow));
        System.out.println("CRC高字节："+String.format("%02x",crcHigh));
    }

    public static void main(String[] args) {
        //打印原始报文
        System.out.println("原始报文"+bytesToHex(MODBUS_MSG));
        //调用解析方法
        parseModbusMsg(MODBUS_MSG);


        System.out.println("=====================");



        //测试高低字节转换
        byte[] testBytes={0x00,0x1E};
        int value=getShortFromHlBytes(testBytes);
        System.out.println("字节[00,1E] 解析后数值："+value);

        // 5. 测试4字节转int
        byte[] intTest = {0x00, 0x00, 0x00, 0x64};
        int intValue = bytesToInt(intTest);
        System.out.println("4字节解析后数值：" + intValue);

        //字符串转字节，字节转字符串
        String content="设备温度30.5℃";
        byte[] bytes=content.getBytes(StandardCharsets.UTF_8);
        System.out.println("字符串转字节输出："+bytes);
        System.out.println("字节转字符串输出"+new String(bytes,StandardCharsets.UTF_8));

    }
    // 模拟一条标准Modbus RTU读取报文
    // 报文：01 03 00 00 00 02 94 0B
    // 含义：从站地址1，读保持寄存器，起始地址0，读取2个寄存器，CRC校验94 0B
    public static final byte[] MODBUS_MSG = hexToBytes("010300000002940B");

}
