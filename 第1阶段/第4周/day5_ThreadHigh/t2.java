package week4;

public class t2 {
    public static void main(String[] args) {
        new Thread(new TT1()).start();
        new Thread(new TT2()).start();
    }
}
class TT1 implements Runnable{
    int n = 0;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 say hello"+n++);
            if (n==10)
                break;
        }
    }
}

class TT2 implements Runnable{
    int n = 0;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 say hi"+n++);
            if (n==10)
                break;
        }
    }
}