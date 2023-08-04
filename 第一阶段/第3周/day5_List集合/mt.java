package week3.day5;

public class mt {
    public static void main(String[] args) {
        //字符串："dderdssdsferdffg"，请找出以哪个字母开头，及哪个字母结尾；并打印前5个字符串和后5个字符串
        String s = "daerdssdsferdffg";
        System.out.println("开头字母："+s.substring(0,1));
        System.out.println("结尾字母："+s.substring(s.length()-1));
        System.out.println(s.substring(0,5));
        System.out.println(s.substring(s.length()-6));

    }
}
