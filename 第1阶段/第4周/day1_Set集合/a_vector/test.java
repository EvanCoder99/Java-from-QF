package week4.day1_Set.a_vector;

import java.util.List;
import java.util.Vector;

public class test {
    public static void main(String[] args) {
        List list =  new Vector();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Object o : list) {
            System.out.println(o);
        }

        //vector除了上述功能，自身也提供了存储和遍历
        Vector v = new Vector();
        v.addElement(4);
        v.addElement(5);
        v.addElement(6);
        //枚举器遍历
    }
}
