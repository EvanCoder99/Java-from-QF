package day2_MyServlet.b_Login.service.impl;

import day2_MyServlet.b_Login.dao.impl.AdminDaoImpl;
import day2_MyServlet.b_Login.entity.Admin;
import day2_MyServlet.b_Login.service.AdminService;
import day2_MyServlet.b_Login.utils.DBUtils;

public class AdminServiceImpl implements AdminService {
    AdminDaoImpl adminDao = new AdminDaoImpl();
    Admin res = null;
    @Override
    public Admin login(String name, String password) {
        //查询不一定非要用事务，但增删改必须使用，即使只有一句sql
        try {
            DBUtils.begin();
            Admin admin = adminDao.queryByName(name);
            if (admin != null && admin.getPassword().equals(password)) {
                res = admin;
            }
            DBUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.rollback();
        }
        return res;
    }

    @Override
    public int register(String name, String phone, String password, String address) {
        Admin admin = new Admin(name,phone,password,address);
        int i = 0;
        try {
            i = adminDao.addAdmin(admin);
            System.out.println("try "+i);
            DBUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.rollback();
        }
        System.out.println("return "+i);
        return i;
    }
}
