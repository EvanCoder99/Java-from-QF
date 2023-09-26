package service;

import entity.User;

import java.util.List;

public interface UserService {
    public int register(User user);
    public User login(String username,String password);
    public User checkUser(String username); //校验用户
    public User selectByCode(String code);  //根据激活码，返回对象
    public int updateStatus(int id);    //根据用户ID，修改状态

    List<User> showVIP();

    int deleteUser(String uId);

    User selectByName(String uName);

    List<User> searchByName(String uName);
}
