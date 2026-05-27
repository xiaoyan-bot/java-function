public class test2 {
    public static void main(String[] args) {
        //定义byte b = 20，将其转为两位小写十六进制字符串并打印
        byte b=20;
        String hex=String.format("%02x",b);
        //x就是把 b 按照16进制转化，2：表示必须输出两位，0：表示不够两位在前面补0
        System.out.println(hex);
        System.out.println("--------------------------");

        //题目二
        //定义十进制字符串String numStr = "35"，转成byte类型输出。
        String numStr="35";
        int num=Integer.parseInt("35");//直接当成字符串来转化
        System.out.println(num);
        byte c=(byte) num;//num=35没有溢出
        System.out.println(c);
        System.out.println("-------------------");

        //题目三
        //十六进制字符串String hexStr = "1f"，先转 int，再强转为 byte 打印结果
        String hexStr="1f";
        int num1=Integer.parseInt(hexStr,16);
        System.out.println(num1);
        //再转为byte
        byte d=(byte) num1;
        System.out.println(d);
        System.out.println("-----------------------");



        //题目5
        String hex1="99";
        int num2=Integer.parseInt("99",16);//没有16，就是把99当成字符串来转化
        System.out.println(num);//转10进制：  9*16^1+9*16^0=153
        byte e=(byte) num2;//转为byte：byte范围-128~127->153溢出，所以溢出的数 - 256 = 最终byte值 153 - 256 = -103
        System.out.println(e);
        System.out.println("----------------------");


        //题目六
        //十六进制字符串String s = "ff"，转换为 byte，观察输出结果并理解原因
        String str="ff";
        int num3=Integer.parseInt("ff",16);
        //转为10进制可以直接转，ff>15*16^1+15*16^0=255
        System.out.println(num3);

        byte f=(byte)num3;//255转为byte超出范围，溢出，转为二进制
        // ff为十六进制   f=二进制 1111  所以ff=1111 1111 因为 最高位是 1 → 负数
        //        负数在计算机里是 补码 存储的，要算真实值必须：
//        求负数真值步骤（补码 → 原码）
//        取反
//        1111 1111 → 0000 0000
//                +1
//        0000 0000 + 1 = 0000 0001
//        加上负号 -1

        System.out.println(f);
        System.out.println("---------------------");




        //题目
        //定义十六进制字符串 String str1 = "A6"
        //把它按十六进制转为 int 类型数值
        //再强制转为 byte 类型，手动算出结果
        //再把这个 byte 值，转回两位小写十六进制字符串
        //最后把十六进制字符串转回普通十进制整数
        String str1="A6";
        int numstr=Integer.parseInt(str1,16);
        System.out.println(numstr);
        byte g=(byte) numstr;//numstr=166  g=166-256
        System.out.println(g);
        String str2=String.format("%02x",g);
        System.out.println(str2);
        int numstr2=Integer.parseInt(str2,16);
        System.out.println(numstr2);




    }
}
