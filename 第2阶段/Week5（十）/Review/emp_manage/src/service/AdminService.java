package service;

import entity.Admin;

public interface AdminService {
    Admin login(String username,String password);
}
