package day2_MyServlet.b_Login.service;

import day2_MyServlet.b_Login.entity.Admin;

public interface AdminService {
    public Admin login(String name, String password);
    public int register(String name,String phone, String password,String address);
}
