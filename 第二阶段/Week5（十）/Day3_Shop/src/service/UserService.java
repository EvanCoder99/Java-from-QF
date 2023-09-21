package service;

import entity.User;

public interface UserService {
    public int register(User user);
    public User login(String username,String password);
    public User checkUser(String username); //校验用户
    public User selectByCode(String code);  //根据激活码，返回对象
    public int updateStatus(int id);    //根据用户ID，修改状态
}
