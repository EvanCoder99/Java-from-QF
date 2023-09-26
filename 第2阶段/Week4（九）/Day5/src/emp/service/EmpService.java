package emp.service;

import emp.entity.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    public List<Emp> showEmps();
    public int addEmp(Emp emp);
    public int deleteEmpByName(String name);

}
