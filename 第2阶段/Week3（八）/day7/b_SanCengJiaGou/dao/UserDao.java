package day7.b_SanCengJiaGou.dao;

import day7.b_SanCengJiaGou.entity.User;

import java.util.List;

public interface UserDao {
    public int addUser(User u);
    public int updateUser(User u);
    public int deleteById(User u);
    public List<User> queryAll();//结果集需要关闭
    public User queryByName(String name);
    public User queryById(int id);
}
