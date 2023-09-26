package week2.day2;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        //冒泡
//        int[] a1 = {3,1,5,7,2};
//        for (int i = 0; i < a1.length-1; i++) {
//            for (int j = 0; j < a1.length-1-i; j++) {
//                if (a1[j]>a1[j+1]){
//                    int temp = a1[j+1];
//                    a1[j+1] = a1[j];
//                    a1[j] = temp;
//                }
//                System.out.println("第"+(i+1)+"轮，第"+(j+1)+"次"+Arrays.toString(a1));
//            }
//            System.out.println();
//        }
//

        //选择排序
        //外层循环：总共比较的轮数
        //内层循环：每轮比较的次数
//        int[] a2 = {3,1,7,5,2};
//        for (int i = 0; i < a2.length - 1; i++) {
//            for (int j = i+1; j < a2.length; j++) {
//                if (a2[i] > a2[j]){  //前面 > 后面
//                    int t = a2[j];
//                    a2[j] = a2[i];
//                    a2[i] = t;
//                }
//                System.out.println("第"+(i+1)+"轮"+Arrays.toString(a2));
//            }
//            System.out.println();
//        }

        //插入排序
        int[] a3 = {3,1,7,5,2};
        for (int i = 0; i < a3.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (a3[j-1] > a3[j]){  //前面 > 后面
                    int t = a3[j];
                    a3[j] = a3[j-1];
                    a3[j-1] = t;
                }
                System.out.println("第"+(i+1)+"轮"+Arrays.toString(a3));
            }
            System.out.println();
        }

    }
}
