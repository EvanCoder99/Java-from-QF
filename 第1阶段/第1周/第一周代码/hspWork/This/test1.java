package week1.hspWork.This;

public class test1 {
    public static void main(String[] args) {
//        1.编写类A01,定义方法max,实现求某个double数组的最大值，并返回

//        double[] d = {1.0,22,99.8,33,4.6};
//        A01 a = new A01();
//        System.out.println(a.max(d));


//        2.编写类A02,定义方法fid,实现查找某字符串数组中的元素查找，并返回索引，如果找不到，返回-1
//        String[] zf = {"11","网二","zxc"};
//        A02 a02 = new A02();
//
//        System.out.println(a02.find(zf,"zxc"));


//        3.编写类Book,定义方法updatePrice,实现更改某本书的价格，具体：如果价格>150,则更改为150，如果价格>100，更改为100，否则不变
//

//        4.编写类A03,实现数组的复制功能copyArr,输入旧数组，返回一个新数组，元素和
//        日数组一样Homework04java


//        5.定义一个圆类Circle,定义属性：半径，提供显示圆周长功能的方法，提供显示圆
//        面积的方法Homework05.java


//        6.编程创建一个Cle计算类，在其中定义2个变量表示两个操作数，定义四个方法实
//        现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试
//        Homework06.java


            //有参数有返回值方法：
            //案例：求两个数的和
            int sum = add(1,2);
            System.out.println("和为："+sum);


//方法实现处需要有int返回值类型；方法体中对应有return 值; 具体值由返回值类型约束

    }
    public static int add(int a,int b) {
        int sum = a+b;
        return sum;
    }
}

class A03{
    public int[] copyArr(int[] oldArr){
        int[] newArr = new int[oldArr.length];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}
class book{
    String name ;
    int price;

    public book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice(){
        if (price>150)
            price = 150;
        else if (price > 100)
            price = 100;
    }
}
class A01{
    public static double max(double[] d){
        double max = d[0];
        for (int i = 0; i < d.length; i++) {
            if (max < d[i])
                max = d[i];
        }
        return max;
    }
}

class A02{
    public static int find(String[] s,String key){
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(key))
                return i;
        }
        return -1;
    }
}