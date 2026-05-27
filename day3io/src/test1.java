import java.io.*;

public class test1 {
    public static void main(String[] args) {
//        String str="D:\\learnIoINputstream\\1.txt";
//        int linecount=0;
//        try
//                (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(str),"UTF-8"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                linecount++;
//            }
//            System.out.println("一共有多少行" + linecount);
//        }catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("文件读取失败！");

            //文件拷贝
            String str1="D:\\learnIoINputstream\\read\\1.txt";
            String dest="D:\\learnIoINputstream\\write\\2.txt";
            try(FileInputStream fis=new FileInputStream(str1);FileOutputStream fos=new FileOutputStream(dest)){
                byte[] b=new byte[1024];int len;
                while ((len=fis.read(b))!=-1){
                    String str= new String(b,0,len);
                    System.out.println(str);
                }
                System.out.println("文件拷贝成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件拷贝失败");
            }

        }

}
