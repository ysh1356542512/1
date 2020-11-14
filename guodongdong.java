package rockhomework4LV1;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class guodongdong implements duixiang {
    static int jingyan = 0,count = 0;
    int LV = 0;
    public void setLV(int x){
        this.LV = x;
    }
    private master m;

    public void setMaster(master m) {
        this.m = m;
    }

    public void print1() {
        System.out.println("    ██              ██");
        System.out.println("  ●                   ●   <----蝴蝶结");
        System.out.println("██   ▋▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▋  ██");
        System.out.println("     ▋   ▇▇      ▇▇   ▋");
        System.out.println("     ▋                ▋");
        System.out.println("     ▋                ▋");
        System.out.println("     ▋●      ◆     ●▋");
        System.out.println("     ▋                ▋");
        System.out.println("●〓〓▋      ↖▄▄↗      ▋〓〓●");
        System.out.println("     ▋▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▋");
        System.out.println("    ╱  |   |   |   |   ╲");
        System.out.println("   ╱   |   |   |   |    ╲   <----裙子");
        System.out.println("   ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔");
        System.out.println("       ┋ ┋         ┋ ┋");
        System.out.println("      ╱   ╲       ╱   ╲");
        System.out.println("      ▔▔▔▔▔       ▔▔▔▔▔           我是你的对象：果冻冻");
    }

    public void print2() {
        System.out.println("    ██              ██");
        System.out.println("  ●                   ● ");
        System.out.print("██   ▋▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▋  ██  LV:  " + LV + "  好感度：" + jingyan+"  ");
        for (int i = 1; i <= 10; i++) {
            if (i <= jingyan%100 / 10) {
                System.out.print("■");
            } else {
                System.out.print("□");
            }
        }
        System.out.println(jingyan % 100 + "/100");
        System.out.println("     ▋   ▇▇      ▇▇   ▋");
        System.out.println("     ▋                ▋       我有以下功能：");
        System.out.println("     ▋                ▋      1.求阶乘    2.求累加   3.求斐波那契数列   4.聊天系统");
        System.out.println("     ▋●      ◆     ●▋      请选择：   ");
        System.out.println("     ▋                ▋");
        System.out.println("●〓〓▋      ↖▄▄↗      ▋〓〓●");
        System.out.println("     ▋▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▋");
        System.out.println("    ╱  |   |   |   |   ╲");
        System.out.println("   ╱   |   |   |   |    ╲  ");
        System.out.println("   ▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔");
        System.out.println("       ┋ ┋         ┋ ┋");
        System.out.println("      ╱   ╲       ╱   ╲");
        System.out.println("      ▔▔▔▔▔       ▔▔▔▔▔ ");
    }

    @Override
    public void choice() {
        System.out.println("                                  我美吗? 请正面回答");
        Scanner sc = new Scanner(System.in);
        System.out.println("                                ");
        String x = sc.next();
        if (x.equals("美")) {
            count =0;
            System.out.println("                                很好你很诚实");
            print2();
            try {
                int y = sc.nextInt();
                if (y >= 1 && y <= 3) {
                    zhixing(y);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (y == 4) {
                    comfortHer();
//            } else {
//                try {
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    choice();
//                }
                }
            }catch (Exception e){
                System.out.println("年轻人你不讲武德 回炉重造");
                choice();
            }
        } else {
            count++;
            if(count <=3) {
                System.out.println("                               你不对劲 再给你一次机会");
                choice();
            } else {
                System.out.println("                                你不诚实 打死你");
                System.exit(0);
            }
        }
    }

    public void zhixing(int x) {
        long result = switch (x) {
            case 1 -> jiecheng();
            case 2 -> leijia();
            case 3 -> feibo();
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
        //        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        m.getInformation(result,x);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.getInformation(result, x);
            upJingyan(1);
        }).start();
    }

    public long jiecheng() {
        Scanner sc = new Scanner(System.in);
        System.out.println("你要求什么数的阶乘");
        int x = sc.nextInt();
        long sum = 1;
        try {
            for (int i = 1; i <= x; i++) {
                sum *= i;
            }
        } catch (Exception e) {
            e.printStackTrace();
            jiecheng();
        }
        return sum;
    }

    public long leijia() {
        Scanner sc = new Scanner(System.in);
        long sum = 0;
        System.out.println("Input number:   输入0结束");
        for (int i = 1; ; i++) {
            try {
                int x = sc.nextInt();
                if (x == 0) {
                    break;
                } else {
                    sum += x;
                    System.out.println("Input next number:");
                }
            } catch (Exception e) {
                continue;
            }
        }
        return sum;
    }

    public long feibo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第几项");
        int n = sc.nextInt();
        ArrayList<Integer> x = new ArrayList();
        x.add(0);
        x.add(1);
        x.add(1);
        for (int i = 3; i <= n; i++) {
            x.add(i, x.get(i - 2) + x.get(i - 1));
        }
        return x.get(n);
    }
    public void language(){
        System.out.println("你有以下选项:");
        System.out.println("1.果冻冻你今天真好看,阿巴阿巴阿巴阿巴阿巴");
        System.out.println("2.果冻冻你不讲武德");
        System.out.println("3.果冻冻你不要伤心了,阿巴阿巴阿巴阿巴阿巴");
        System.out.println("4.果冻冻你不要生气了,阿巴阿巴阿巴阿巴阿巴");
    }
    public void upJingyan(int x){
        Random r = new Random();
        switch (x){
            case 1:
                System.out.println("你们更加亲密了");
                int y = r.nextInt(50)+50;
                jingyan+=y;
                System.out.println("亲密度增加"+y);
                setLV(jingyan/100);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                choice();
            case 2:
                int z = r.nextInt(20)+10;
                jingyan-=z;
                setLV(jingyan/100);
                System.out.println("你的亲密度下降并且进入封神榜名单 3天");
                System.out.println("亲密度减少"+z);
                try {
                    Thread.sleep(2000);
                    System.out.println("还有2天");
                    Thread.sleep(2000);
                    System.out.println("还有1天");
                    Thread.sleep(2000);
                    System.out.println("解禁啦");
                    choice();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
    public void comfortHer() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int x = r.nextInt(4) + 1;
        switch (x) {
            case 1:
                System.out.println("       ☺      今天的果冻冻心情很八错");
                print1();
                System.out.println("果冻冻：针不戳 今天的天气针不戳");
                upJingyan(1);
                break;
            case 2:
                System.out.println("               今天的果冻冻心情一般 试着去夸一夸她吧");
                print1();
                System.out.println("果冻冻: 又是平平淡淡的一天");
                language();
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("你：果冻冻你今天真好看,阿巴阿巴阿巴阿巴阿巴");
                        System.out.println("果冻冻：小嘴真甜 喜欢你这样叫我");
                        upJingyan(1);
                        break;
                    default:
                        System.out.println("果冻冻：年轻人你不讲武德 来 骗 来 偷袭 我美丽的老机器人 这好吗 这不好 希望你耗子尾之");
                        upJingyan(2);
                        break;
                }
            case 3:
                System.out.println("       ☹      今天的果冻冻很伤心 试着去安慰一下她吧");
                print1();
                System.out.println("果冻冻：又是难过的一天");
                language();
                int choice1 = sc.nextInt();
                switch (choice1){
                    case 3:
                        System.out.println("果冻冻：谢谢你 我感觉好多了");
                        upJingyan(1);
                        break;
                    default:
                        System.out.println("果冻冻：年轻人你不讲武德 来 骗 来 偷袭 我美丽的老机器人 这好吗 这不好 希望你耗子尾之");
                        upJingyan(2);
                        break;
                }
            case 4:
                System.out.println("       ┚┖  ┚┖    今天的果冻冻很生气 试着去哄一下她吧");
                System.out.println("       ┒┎  ┒┎");
                print1();
                System.out.println("果冻冻：莫嘻嘻哈哈");
                language();
                int choice2 = sc.nextInt();
                switch (choice2){
                    case 4:
                        System.out.println("果冻冻：好吧 感觉好点了");
                        upJingyan(1);
                        break;
                    default:
                        System.out.println("果冻冻：年轻人你不讲武德 来 骗 来 偷袭 我美丽的老机器人 这好吗 这不好 希望你耗子尾之");
                        upJingyan(2);
                        break;
                }
        }
    }
}
