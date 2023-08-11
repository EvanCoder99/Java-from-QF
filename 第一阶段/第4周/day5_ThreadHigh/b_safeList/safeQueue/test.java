package week4.day5_ThreadHigh.b_safeList.safeQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class test {
    public static void main(String[] args) {
        //ConcurrentLinkedQueue实现类：内部采用CAS无锁交换算法-没有加锁也能确保安全
        //队列的特点，先进先出
        //内部实现：维护了三个参数 V-要替换的值 E-预期值 N-新值
        //如果在执行中一直能匹配V=E，则新值可以替换旧值V=N，说明没有人更改过值，即可存进来；否则舍弃N的存储
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("zs");
        queue.add("ls");
        queue.add("ww");
        //前面没有add元素，则后面移除和获取元素都会报错
        System.out.println("移除的元素："+queue.remove());//返回并移除元素（从第一个开始移除）
        System.out.println("返回的元素："+queue.element());//返回并不移除
        System.out.println(queue);

        Queue<String> queue2 = new ConcurrentLinkedQueue<>();
        queue2.offer("zs");
        queue2.offer("ls");
        //前面没有add元素，后面移除和获取元素不会报错
        System.out.println("移除的元素："+queue2.poll());//返回并移除
        System.out.println("返回的元素："+queue2.peek());//返回并不移除
        System.out.println(queue2);
    }
}
