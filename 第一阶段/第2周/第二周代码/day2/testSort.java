package week2.day2;

import java.util.Arrays;

public class testSort {
    public static void main(String[] args) {
        //在整型数组中,找出最小的元素
        //冒泡排序
        //外层循环：总共比较的轮数
        //内层循环：每轮比较的次数
//        int[] a = {47,32,99,68,7,5,32};
//        System.out.print("原数组长： "+Arrays.toString(a)+"\n");
//        int temp = a[0];
//        int count = a.length-1;
//        for (int i = 0; i < a.length-1; i++) {
//            for (int j = 0; j < count; j++) {
//                if (a[j]>a[j+1]){
//                    temp = a[j+1];
//                    a[j+1] = a[j];
//                    a[j] = temp;
//                }
//                System.out.print("第"+(i+1)+"轮，第"+(j+1)+"次比较："+Arrays.toString(a)+"\n");
//            }
//            System.out.println();
//            count--;
//        }


        //选择排序：
        //假设第一个最小，依次与后面的元素比较
        //小的放左边，比较完一轮，最左边最小，以此类推，共比较长度-1轮
//        int[] a = {3,1,5,2};
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = i+1; j < a.length; j++) {
//                if (a[i] > a[j]){
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//            System.out.println("第"+(i+1)+"轮"+Arrays.toString(a));
//        }


        //插入排序：
        //插入排序：第一轮先比较前两个元素：第二轮插入一个元素与第一轮最大的比：
        //如果比最大的还要大，直接排下来：否则再和前面的比，以此类推，
        //共比较(长度-1)轮
//        int[] a = {3,1,5,2};
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = i+1; j >0; j--) {
//                if (a[j-1] > a[j]){ //如果前一个比后一个大，则交换
//                    int temp = a[j];
//                    a[j] = a[j-1];
//                    a[j-1] = temp;
//                }else
//                    break;
//            }
//            System.out.println(Arrays.toString(a));
//        }

        String s = null;
        String a = "";
        System.out.println(a.equals(s));

    }
    public static String tt(String s){
        return s;
    }
}
