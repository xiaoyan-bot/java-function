public class endtest {
    public static void main(String[] args) {
        byte[] msg=methodtest2.hextobyte("01001E0032");
        byte devId=msg[0];
        byte[] tempBytes={msg[1],msg[2]};
        byte[] humiBytes={msg[3],msg[4]};
        int temp = twoBytesToInt(tempBytes);
        int humi = twoBytesToInt(humiBytes);

        System.out.println("设备id"+devId);
        System.out.println("温度"+methodtest2.bytetohex(tempBytes));
        System.out.println("湿度"+methodtest2.bytetohex(humiBytes));

        System.out.println("实际温度："+temp+"℃");
        System.out.println("实际湿度："+humi+"%");






    }
    public static int twoBytesToInt(byte[] b){
        int high=b[0]&0xFF;
        int low=b[1]&0xFF;
        return high*256+low;
    }
}
