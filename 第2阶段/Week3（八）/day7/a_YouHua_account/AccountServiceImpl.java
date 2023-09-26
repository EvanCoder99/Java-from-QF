package day7.a_YouHua_account;

import java.sql.Connection;

public class AccountServiceImpl {
    //参数1：发送方卡号  参数2：收款方卡号  参数3：密码  参数4：金额
    public int transfer(String sendCart,String acceptCart,String password,int money) {
        Connection con = null;
        try {
            //业务逻辑判断，一个业务包含多个dao功能
            AccountDao accountDao = new AccountDao();//创建dao对象

            //一、发送方账户业务逻辑判断
            Account sendAccount = accountDao.selectCart(sendCart);
            if (sendAccount == null) {//判断发送方账户是否存在
                throw new RuntimeException("没有发送方账户");
            }
            if (!password.equals(sendAccount.getPassword())) {//发送方密码是否匹配
                throw new RuntimeException("发送方密码错误");
            }
            if (sendAccount.getMoney() < money) {
                throw new RuntimeException("发送方余额不足");
            }

            //二、收款方账户业务逻辑判断
            Account acceptAccount = accountDao.selectCart(acceptCart);
            if (acceptAccount == null) {//判断收款方账户是否存在
                throw new RuntimeException("没有收款方账户");
            }
            if (!password.equals(acceptAccount.getPassword())) {//收款方密码是否匹配
                throw new RuntimeException("收款方密码错误");
            }
            if (acceptAccount.getMoney() < money) {
                throw new RuntimeException("收款方余额不足");
            }

            //三、--转账操作--
//            con = JDUtilsProperties.getConnection();
//            con.setAutoCommit(false);   //手动开启事务提交
            DBUtils.begin();    //事务封装

            sendAccount.setMoney(sendAccount.getMoney() - money);
            int res = accountDao.updataAccMoney(sendAccount);
            System.out.println("发送方转账记录："+res);

            int i = 5/0;    //主动异常，模拟回滚

            acceptAccount.setMoney(acceptAccount.getMoney() + money);
            res = accountDao.updataAccMoney(acceptAccount);
            System.out.println("收款方转账记录："+res);

//            con.commit();   //提交事务，出现异常则要回滚
            DBUtils.commit();//事务封装

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("事务回滚");
            DBUtils.rollback();
        }/*finally {    //业务层已经不需要关闭了，统一在commit()和rollback()关闭
            JDUtilsProperties.closeAll(con);
        }*/
        return 0;
    }
}
