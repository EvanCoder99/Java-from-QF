package week5.day5;

//请写出单例的懒汉式和饿汉式代码，并注释标明
class mySingle{
    private static mySingle ms2 = new mySingle();//饿汉模式
    private static mySingle ms;//懒汉模式

   public mySingle(){}
    public static mySingle getInstance(){
        if (ms != null)
            return ms = new mySingle();
        return ms;
    }

}
public class test {
    public static void main(String[] args) {
        mySingle ms1 = mySingle.getInstance();
    }
}
