package rockhomework4LV2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> stuList = new ArrayList<Student>();
    public static void main(String[] args) {
        zhuye();
    }
    public static void saveStudent(){
        float temp = 0;
        Student student = new Student();
        System.out.println("请输入学号");
        student.setCard(sc.next());
        System.out.println("请输入姓名");
        student.setName(sc.next());
        System.out.println("请输入数学成绩");
        student.setMath(sc.nextFloat());
        System.out.println("请输入英语成绩");
        student.setEnglish(sc.nextFloat());
        System.out.println("请输入语文成绩");
        student.setChinese(sc.nextFloat());
        System.out.println("请输入化学成绩");
        student.setScience(sc.nextFloat());
        temp += student.getMath();
        temp += student.getEnglish();
        temp += student.getChinese();
        temp += student.getScience();
        student.setSum(temp);
        student.setAverage(temp/4);
        stuList.add(student);
    }
    public static void listStudent(){
        for(Student student:stuList){
            System.out.println(student.toString());
        }
    }
    public static void removeStudent(){
        System.out.println("请输入要删除的学生姓名：");
        String name = sc.next();
        if(find(name) == null){
            System.out.println("查无此人");
        } else {
            stuList.remove(find(name));
            System.out.println("已删除学生"+name+"的相关信息");
        }
    }
    public static void seekStudent(){
        System.out.println("请输入要查找的学生姓名：");
        String name = sc.next();
        if(find(name)== null){
            System.out.println("查无此人");
        } else {
            System.out.println(find(name).toString());
        }
    }
    public static void setStudent(){
        float score = 0;
        System.out.println("请输入要修改的学生姓名：");
        String name = sc.next();
        if(find(name)==null){
            System.out.println("查无此人");
        } else {

        }
    }
    public static void sortStudent(){
        System.out.println("请输入需要排序的科目或者总分(输入 数学 语文 英语 化学 总分 平均分)");
        String subject = sc.next();
        switch(subject){
            case "数学":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getMath()<stuList.get(j).getMath()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
            case "语文":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getChinese()<stuList.get(j).getChinese()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
            case "英语":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getEnglish()<stuList.get(j).getEnglish()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
            case "化学":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getScience()<stuList.get(j).getScience()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
            case "总分":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getSum()<stuList.get(j).getSum()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
            case "平均分":
                for(int i = 0;i<stuList.size();i++){
                    Student s = stuList.get(0);
                    for(int j = 1;j<stuList.size();j++){
                        if(stuList.get(j-1).getAverage()<stuList.get(j).getAverage()){
                            s = stuList.get(j);
                            stuList.set(j,stuList.get(j-1));
                            stuList.set(j-1,s);
                        }
                    }
                }
                break;
        }
        listStudent();
    }
    public static Student find(String name){
        for(Student student : stuList) {
            if(name.equals(student.getName())){
                return student;
            }
        }
        return null;
    }
    public static void zhuye(){
        int choice = 0;
        System.out.println("1.添加一条学生数据");
        System.out.println("2.删除一条学生数据");
        System.out.println("3.查找一条学生数据");
        System.out.println("4.修改一条学生数据");
        System.out.println("5.显示一条学生数据");
        System.out.println("6.按照学生成绩排序");

        while(true){
            System.out.println("请选择");
            choice  = sc.nextInt();
            switch (choice){
                case 1: saveStudent(); break;
                case 2: removeStudent(); break;
                case 3: seekStudent(); break;
                case 4: setStudent(); break;
                case 5: listStudent(); break;
                case 6: sortStudent(); break;
            }
        }
    }
}
