package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    public Admin login(String username, String password) {
        try {
            Admin admin = adminDao.selectByName(username);
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
