package week4.day3_Exception.a_Thread_Basic;

public class test {
    public static void main(String[] args) {
        //异常传递：在方法实现中出现异常，可以传递到调用处
        f();
        System.out.println("最后执行...");
    }
    //将该代码块->选中->快捷健ctrL+aLt+t->达中try-catch
   private static void f(){
       try {
           int i=1/0;
       } catch (Exception e) {
           e.printStackTrace();
       }

       System.out.println("方法实现最后执行");
   }
}
