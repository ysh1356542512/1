package rockhomework4LV4;

public class lei {
    public static int number = 100; public static String city = "重庆";
    private int age; private String name = "sb";
    private void printf(){
        System.out.println("年龄为"+age+"的"+name+"在一个人口为"+number+"的"+city);
    }
    public lei(){
        this("sb",1);
    }
    public lei(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println(name + age);
    }
    protected lei(boolean n){
        System.out.println("受保护的构造方法n = "+n);
    }
    private lei(int age){
        System.out.println(age);
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }
}
