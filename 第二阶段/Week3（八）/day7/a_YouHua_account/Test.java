package day7.a_YouHua_account;

public class Test {
    //转账功能
    //层次结构：test类、utils类、entity类、dao层、service业务层
    //110 给 120 转账100
    public static void main(String[] args) {
        AccountServiceImpl asi = new AccountServiceImpl();
        int transfer = asi.transfer("10086", "10010", "123", 100);
        System.out.println(transfer);

    }
}
