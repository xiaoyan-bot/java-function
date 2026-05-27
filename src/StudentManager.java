import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("------- 学生名单管理系统---------");
            System.out.println("      1.添加学生               ");
            System.out.println("      2.修改学生信息            ");
            System.out.println("      4.查询学生信息            ");
            System.out.println("      3.删除学生信息            ");
            System.out.println("      0.退出系统               ");
            System.out.println("                      请输入你要选择的操作               ");

            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    //添加学生
                    System.out.println("请输入学生id");
                    int id=sc.nextInt();
                    System.out.println("请输入学生姓名");
                    String name=sc.next();
                    System.out.println("请输入学生年龄");
                    int age= sc.nextInt();
                    list.add(new Student(id,name,age));
                    System.out.println("添加成功");
                    break;
                case 2:
                    //修改学生信息
                    System.out.println("请输入要修改学生的id");
                    int id1=sc.nextInt();
                    boolean exists3=false;
                    for (Student student : list) {
                        if (student.getId() == id1) {
                            System.out.println("请输入学生新年龄");
                            int age1 = sc.nextInt();
                            student.setAge(age1);
                            System.out.println("请输入学生的新名字");
                            String name1 = sc.next();
                            student.setName(name1);
                            System.out.println("修改成功");
                            exists3 = true;
                            break;
                        }

                    }
                    if(!exists3){
                        System.out.println("修改失败，该学生不存在");
                    }
                    break;
                //id不存在

                case 3:
                    //删除学生
                    boolean exists=false;
                    if(list.size()==0){
                        System.out.println("学生管理系统暂时没有学生");
                        break;
                    }
                    else{
                        System.out.println("请输入你要删除学生的id");
                        int id2=sc.nextInt();
                        for (int i = 0; i <list.size() ; i++) {
                            Student s=list.get(i);
                            if(id2==s.getId()){
                                list.remove(i);
                                exists=true;
                                System.out.println("删除成功");
                                break;
                            }

                        }
                    }
                    if(!exists){
                        System.out.println("没有找到这个学生，删除失败");
                    }
                    break;


                case 4:
                    //查询学生信息
                    System.out.println("输入1为查询单个学生信息，输入2为查询所有学生信息");
                    int temp=sc.nextInt();
                    if(temp==1){
                        boolean exists2=false;
                        System.out.println("请输入你要查询学生的id");
                        int id3=sc.nextInt();
                        for (Student student : list) {
                            if(student.getId()==id3){
                                exists2=true;
                                System.out.println(student.toString());break;
                            }
                        }
                        if(!exists2){
                            System.out.println("该学生不存在,查询失败");
                        }

                    }
                    else if(temp==2){
                        System.out.println(list);
                    }
                    break;


                case 0:
                    System.out.println("再见");
                    sc.close();
                    return;

                default:
                    System.out.println("输入信息有错，请重新输入");










            }
        }
    }
}
