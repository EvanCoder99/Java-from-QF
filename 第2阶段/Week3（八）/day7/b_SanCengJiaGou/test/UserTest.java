package day7.b_SanCengJiaGou.test;

import day7.b_SanCengJiaGou.entity.User;
import day7.b_SanCengJiaGou.service.UserService;
import day7.b_SanCengJiaGou.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    /*
    * create table user(
    *   id int primary key auto_increment,
    *   name varchar(20),
    *   age int
    * )
    *
    * */
    private UserService userService = new UserServiceImpl();
    @Test
    public void registerTest() {
        User user = userService.register("zs");
        System.out.println(user);
    }
}
