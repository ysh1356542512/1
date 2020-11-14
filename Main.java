package rockhomework4LV5_6;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> m = new MyList<>();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(3,4);
        m.print();
        m.remove(2);
        m.print();
        m.set(2,5);
        m.print();
        System.out.println(m.getIndex(2));
    }
}
