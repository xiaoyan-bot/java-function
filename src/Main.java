import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Student> stuMap=new HashMap<>();
        stuMap.put(100,new Student(1,"张三",18));
        stuMap.put(101,new Student(2,"李四",19));
        stuMap.put(102,new Student(3,"王五",20));
//        System.out.println(stuMap);
//        //删除
//        stuMap.remove(101);
//        System.out.println("删除后"+ stuMap);
//        //修改
//        stuMap.get(100).setName("赵六");
//        System.out.println("修改后"+ stuMap);
//        //查询
//        for(Map.Entry<Integer,Student> entry:stuMap.entrySet()){
//            System.out.println("序号为"+entry.getKey()+"的学生信息为"+entry.getValue().getId()+entry.getValue().getName());
//        }
        System.out.println(stuMap.get(100));
    }
}