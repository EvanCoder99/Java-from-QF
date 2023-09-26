package emp.service.impl;

import emp.dao.impl.EmpDaoImpl;
import emp.entity.Emp;
import emp.service.EmpService;

import java.sql.SQLException;
import java.util.List;

//员工业务层
public class EmpServiceImpl implements EmpService {
    private EmpDaoImpl empDao = new EmpDaoImpl();

    @Override
    public int addEmp(Emp emp)  {
        try {
            return empDao.add(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmpByName(String name) {
        try {
            return empDao.deleteByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Emp> showEmps() {
        try {
            List<Emp> emps = empDao.selectEmp();
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
