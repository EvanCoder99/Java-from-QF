package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import utils.MD5Utils;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int register(User user) {
        try {
            return userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.selectByName(username);
            //user不为空 且 MD5加密 匹配则返回对象
            if (user != null && user.getU_password().equals(MD5Utils.md5(password))) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User checkUser(String username) {
        try {
            User user = userDao.selectByName(username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User selectByCode(String code) {
        try {
            return userDao.selectByCode(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateStatus(int id) {
        try {
            return userDao.updateStatus(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> showUsers() {
        try {
            return userDao.selectUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteUser(String uId) {
        try {
            return userDao.deleteUser(uId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> searchUsers(String uName, String uSex) {
        try {
            return userDao.searchUsers(uName,uSex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
