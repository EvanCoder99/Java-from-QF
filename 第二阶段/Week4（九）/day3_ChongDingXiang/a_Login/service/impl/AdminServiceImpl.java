package day3_ChongDingXiang.a_Login.service.impl;

import day3_ChongDingXiang.a_Login.dao.impl.AdminDaoImpl;
import day3_ChongDingXiang.a_Login.entity.Admin;
import day3_ChongDingXiang.a_Login.service.AdminService;
import day3_ChongDingXiang.a_Login.utils.DBUtils;

import java.util.List;

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
            System.out.println(admin);
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
            DBUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.rollback();
        }
        return i;
    }

    @Override
    public List<Admin> showAdmins() {
        DBUtils.begin();  //开启事务
        try {
            List<Admin> list = adminDao.queryAdmins();
            System.out.println("前："+list);
            DBUtils.commit();  //提交事务
            System.out.println("后："+list);
            return list;  //返回集合
        }catch (Exception e){
            DBUtils.rollback();  //回滚事务
        }

        return null;
    }
}
