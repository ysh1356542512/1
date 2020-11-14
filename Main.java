package rockhomework4LV4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

//因为不知道怎么把类对象当做方法的参数 所以就看小黄书写了 嘿嘿嘿
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class leiClass = lei.class;
        try {
            Constructor<?> con[] = leiClass.getDeclaredConstructors();
            System.out.println("你有以下构造方法：");
            for(int i = 0;i<con.length;i++){
                Class<?> p[] = con[i].getParameterTypes();
                System.out.print("构造方法"+(i+1)+": ");
                int mo = con[i].getModifiers();
                System.out.print(Modifier.toString(mo)+" ");
                System.out.print(con[i].getName());
                System.out.print("(");
                for(int j = 0;j<p.length;j++){
                    System.out.print(p[j].getName()+" arg"+i);
                    if(j<p.length-1){
                        System.out.print(",");
                    }
                }
                System.out.println("){}");
            }
            System.out.print("你要选择哪种构造方法构造：");
            lei lei = null;
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            switch (x){
                case 1:
                    int y = sc.nextInt();
                    con[0].setAccessible(true);
                    lei = (rockhomework4LV4.lei) con[0].newInstance(y);
                    break;
                case 4:
                    boolean z = sc.hasNext();
                    lei = (rockhomework4LV4.lei) con[3].newInstance(z);
                    break;
                case 2:
                    String name = sc.next(); int age = sc.nextInt();
                    lei = (rockhomework4LV4.lei) con[1].newInstance(name,age);
                    break;
                case 3:
                    lei = (rockhomework4LV4.lei) con[2].newInstance();
                    break;
            }
            System.out.println("有以下方法");
            Method[] m = leiClass.getDeclaredMethods();
            for (int i = 0;i<m.length;i++) {
                Class<?> r = m[i].getReturnType();
                Class<?>[] p = m[i].getParameterTypes();
                System.out.print("方法"+(i+1)+": ");
                int xx = m[i].getModifiers();
                System.out.print(Modifier.toString(xx) + " ");
                System.out.print(r.getName() + " ");
                System.out.print(m[i].getName());
                System.out.print("(");
                for (int j = 0; j < p.length; j++) {
                    System.out.print(p[j].getName()+" "+"arg"+j);
                    if(j<p.length-1){
                        System.out.print(",");
                    }
                }
                Class<?> ex[] = m[i].getExceptionTypes();
                if(ex.length>0){
                    System.out.print(")throws ");
                } else {
                    System.out.print(")");
                }
                for(int j = 0;j<ex.length;j++){
                    System.out.print(ex[j].getName());
                    if(j<ex.length-1){
                        System.out.println(",");
                    }
                }
                System.out.println();
            }
            System.out.print("请选择你要调用的方法：");
            int choice = sc.nextInt();
            switch (choice){
                case 4:
                    System.out.println(m[3].invoke(lei));
                    break;
                case 1:
                    String name = sc.next();
                    m[0].invoke(lei,name);
                    System.out.println("变量已改为"+name);
                    break;
                case 2:
                    m[1].setAccessible(true);
                    m[1].invoke(lei);
                    break;
                case 5:
                    int age = sc.nextInt();
                    m[4].invoke(lei,age);
                    System.out.println("变量已改为"+age);
                    break;
                case 3:
                    System.out.println(m[2].invoke(lei));
                    break;
            }
            System.out.println("有以下属性");
            int count = 1;
            {
            Field [] f = leiClass.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                Class<?> r = f[i].getType();
                int mo = f[i].getModifiers();
                String p = Modifier.toString(mo);
                if(!p.equals("public static")&&!p.equals("public")) {
                    System.out.print("本类属性 "+count+":");
                    count++;
                    System.out.print(p + " ");
                    System.out.print(r.getName() + " ");
                    System.out.print(f[i].getName());
                    System.out.println(";");
                }
            }

            }
            System.out.println("-----------------------");
            {
                Field f[] = leiClass.getFields();
                for (int i = 0; i < f.length; i++) {
                    Class<?> r = f[i].getType();
                    int mo = f[i].getModifiers();
                    String p = Modifier.toString(mo);
                    System.out.print("公共属性 "+count+":");
                    count++;
                    System.out.print(p+" ");
                    System.out.print(r.getName());
                    System.out.print(f[i].getName());
                    System.out.println(";");
                }
            }
            System.out.print("请选择你要调用的属性：");
            int choice1 = sc.nextInt();
            switch (choice1){
                case 1:
                    System.out.print("请输入你要修改的值：");
                    int age = sc.nextInt();
                    Field ageField = leiClass.getDeclaredField("age");
                    ageField.setAccessible(true);
                    ageField.set(lei,age);
                    System.out.println("变量age已改为"+ageField.get(lei));
                    break;
                case 2:
                    System.out.print("输入你要修改的值：");
                    String name = sc.next();
                    Field nameField = leiClass.getDeclaredField("name");
                    nameField.setAccessible(true);
                    nameField.set(lei,name);
                    System.out.println("变量name已改为"+nameField.get(lei));
                    break;
                case 3:
                    System.out.print("请输入你要修改的值：");
                    int number = sc.nextInt();
                    Field numberField = leiClass.getDeclaredField("number");
                    numberField.set(lei,number);
                    System.out.println("变量number已改为"+numberField.get(lei));
                    break;
                case 4:
                    System.out.print("请输入你要修改的值：");
                    String city = sc.next();
                    Field cityField = leiClass.getDeclaredField("city");
                    cityField.set(lei,city);
                    System.out.println("变量city已改为"+cityField.get(lei));
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    public void Construction(Object object){
//        try {
//            Constructor<?> con[] = object.getConstructors();
//            System.out.println("你有以下构造方法：");
//            for(int i = 0;i<con.length;i++){
//                Class<?> p[] = con[i].getParameterTypes();
//                System.out.print("构造方法"+(i+1)+":");
//                System.out.print(con[i].getModifiers()+"");
//                System.out.println(con[i].getName());
//                System.out.print("(");
//                for(int j = 0;j<p.length;j++){
//                    System.out.print(p[j].getName()+"arg"+i);
//                    if(j<p.length-1){
//                        System.out.println(",");
//                    }
//                }
//                System.out.println("){}");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
