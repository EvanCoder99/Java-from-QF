package week3.day4.a_String;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
//        String a = "hello";
//        String b = a.concat(" word"); //字符串拼接符，等价+
//        System.out.println(a);  //hello
//        System.out.println(b);  //hello word
//
//        System.out.println(a.charAt(2));//根据下表获取对应字符
//        System.out.println(a.contains("ll"));//判断是否包含子串
//        char[] c = a.toCharArray();
//        System.out.println(c.toString());//将字符串转为数组
//        System.out.println(a.indexOf("ll")); //匹配字串返回下标；匹配不上返回-1
//        System.out.println("  abc ddd  ".trim()); //去除前后空格
//
//        System.out.println(a.toUpperCase()); //小写转大写
//        System.out.println("HEL".toLowerCase()); //大写转小写
//        System.out.println(a.endsWith("lo")); //是否以子串结尾
//        System.out.println(a.startsWith("el")); //是否以子串开头
//
//        //参数为正则表达式规则的字符串：
//        //正则表达式：代表特定规则含义的字符串序列  例如：按.拆分  .在正则表达式规则中表示任意字符
//        String[] ss = a.split("e"); //以字串进行拆分
//        System.out.println(Arrays.toString(ss));
//
//        String[] bb = "aa.bb.cc".split("[.]"); //.要通过[]转义
//        System.out.println(Arrays.toString(bb));

        //replace  VS  replaceAll
        String name = "暴力的黄色小说，很暴力";
        System.out.println(name.replace("暴力", "**"));
        System.out.println(name.replaceAll("暴力", "**"));
        //replace：完全匹配  replaceAll：可以完全也可以按规则匹配
        //例如：把一串字符中的手机号替换成***  “答复13838383838对方13636363636应用”
        //手机号规则：1开头   11位，纯数字
        String c = "答复13838383838对方13636363636应用";
        //System.out.println(c.replace("13838383838", "***"));
        //[0-9]:0~9的一个数字 {10} 量词，正好10个
        System.out.println(c.replaceAll("1[0-9]{10}", "***"));

    }
}
