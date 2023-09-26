package day7.b_SanCengJiaGou.service.impl;

import day7.b_SanCengJiaGou.dao.UserDao;
import day7.b_SanCengJiaGou.dao.imp.UserDaoImpl;
import day7.b_SanCengJiaGou.entity.User;
import day7.b_SanCengJiaGou.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();//接口多态
    @Override
    public User register(String name) {
        return userDao.queryByName(name);
    }
}
