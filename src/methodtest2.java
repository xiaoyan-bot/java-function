import java.util.Scanner;

public class methodtest2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你想要转化byte的字符串");
        String str=sc.next();
        System.out.println(hextobyte(str));

    }






    public static byte[] hextobyte(String s){
        byte[] bytes=new byte[s.length()/2];
        for (int i = 0; i <s.length() ; i+=2) {
            String string=s.substring(i,i+2);
            int num=Integer.parseInt(string,16);
            bytes[i/2]=(byte) num;
        }
        return bytes;
    }
    public  static String bytetohex(byte[] b){
        StringBuilder sb=new StringBuilder();
        for (byte b1 : b) {
            sb.append(String.format("%02x",b1));
        }
        String string = sb.toString();
        return string;
    }

}

