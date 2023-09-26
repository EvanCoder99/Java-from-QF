package emp.service.impl;

import emp.dao.EmpManagerDao;
import emp.dao.impl.EmpManagerDaoImpl;
import emp.entity.Empmanager;
import emp.service.EmpManagerService;

import java.sql.SQLException;

//管理员业务层
public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public Empmanager login(String username, String password) {
        //事务略，暂时不加，以后框架加
        try {
            Empmanager empmanager = empManagerDao.selectByName(username);
            if (empmanager.getPassword().equals(password)) {
                return empmanager;//用户名或密码正确返回对象
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    //返回null
    }
}
