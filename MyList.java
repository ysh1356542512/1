package rockhomework4LV5_6;

import java.util.Iterator;

public class MyList<T> implements Iterable<T>{
    private Node root;            //定义根节点
    private static class Node<T>{      //节点类
        Node<T> next;              //保存下一个节点  该节点里有下一个节点的地址值以及它自身T对象的属性t
        T t;         
        public Node(Node next,T t){  //设置下一个节点的方法
            this.next = next;
            this.t = t;
        }
    }
    private int size;

    public int size() {
        return size;
    }

    public T getElement(int index) {       //输入索引 返回元素
        if(index<0||index>=size){                //如果索引越界则抛出异常
            throw new IndexOutOfBoundsException("数组越界");
        }
        return node(index).t;
    }

    private Node<T> node(int index) { //因为我们最终做成的是一个类似数组的集合 所以将第几个node类似于数组中的索引
        Node x = root;
        for (int i = 0; i < index; i++) {    //root里面的node.next在一开始就有 所以不需要遍历就能得到 相当于索引0 遍历0次
            x = x.next;                      //因此可以类比为 查找索引几 那就遍历几次
        }
        return x;
    }

    public int getIndex(T t) {             //输入元素 返回索引
        Node node = root;                     //实例node为根
        if(t == null){                  //因为null不能用equals比较 否则会出现空指针异常 所以将两种情况分开
            for (int i = 0; i < size; i++) {
                if(node.t != null){       //如果不对 那就跳到下一个Node
                    node = node.next;
                } else{
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {   //同理
                if(t.equals(node.t)){
                    return i;
                } else {
                    node = node.next;
                }
            }
        }
        return -1;      //如果没有该元素 则返回-1
    }

    public void add(int index, T t) {    //在索引index-1和index之间插入一个数
        if(index<0||index>size){//因为这是链节 所以要把Node index-1上的地址值改成要新建的node的地址值 再将新建的node的地址值改成原本Nodeindex的地址值
            throw new IndexOutOfBoundsException("数组越界");
        }
        if(index == 0){
            root = new Node(root,t);
            size++;
        }else {
            Node<T> node1 = node(index - 1); //获得Node index-1
            Node<T> node2 = node(index);          //获得Node index
            node1.next = new Node<>(node2, t);    //将node1的next地址值改成新建的Node
            size++;
        }
    }

    public void add(T t) {  //直接在链表最后增加node
        add(size,t);
    }

    public T set(int index, T t) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("数组越界");
        }
        Node<T> node = node(index);  //通过node方法获得index索引上的值
        T old = node.t;             //交换新旧t
        node.t = t;
        return old;                 //返回旧t
    }

    public T remove(int index) {        //删除索引  就是把链表node的地址值修改 脱离出的node就会被当做垃圾回收
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("数组越界");
        }
        if(index == 0){            //如果索引为0 把根的next地址值改成null
            Node<T> old = node(index);
            root.next = null;
            size--;              //记录元素减一
            return old.t;
        } else if(index == size-1){      //如果索引为最后 那么把前一个索引的地址值删除
            Node<T> node1 = node(index-1);
            Node<T> old = node(index);
            node1.next = null;
            size--;                    //记录元素减一
            return old.t;
        } else{
            Node<T> node1 = node(index-1);      //把前一个的next地址值改成后一个的地址值
            Node<T> node2 = node(index+1);
            Node<T> old = node1.next;
            node1.next = node2;
            size--;
            return old.t;
        }
    }
    public Iterator<T> iterator(){    //迭代器
        return new Itr();
    }
    class Itr implements Iterator<T>{
        int count = 0;
        @Override
        public boolean hasNext() {
            return count!=size;
        }
        @Override
        public T next() {
            count++;
            return getElement(count-1);
        }
    }
    public void print() {
        for (T t : this) {                      //实现foreach
            System.out.print(t+"  ");
        }
        System.out.println();
    }
}
