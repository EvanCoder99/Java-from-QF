package day3_ChongDingXiang.a_Login.service;

import day3_ChongDingXiang.a_Login.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String name, String password);
    public int register(String name,String phone, String password,String address);
    public List<Admin>  showAdmins();
}
