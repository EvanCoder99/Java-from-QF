package emp.service;

import emp.entity.Emp;
import emp.entity.Page;

import java.util.List;

public interface EmpService {
    public List<Emp> showEmps();
    public int addEmp(Emp emp);
    public int deleteEmpByName(String name);
    public int updateEmp(Emp emp);
    public Emp selectById(int id);

    public Page<Emp> getPage(String current);
}
