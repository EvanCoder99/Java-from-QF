package week5.day6;

public class logTest {
    public static void main(String[] args) {
        Logger.log("用户尝试进行登录，验证失败！");
        Logger.log("调用了System类的gc()方法，建议启动垃圾回收");
    }
}
