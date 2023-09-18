package emp.service.impl;

import emp.dao.impl.EmpDaoImpl;
import emp.entity.Emp;
import emp.entity.Page;
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
    public int updateEmp(Emp emp) {
        try {
            return empDao.update(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp selectById(int id) {
        try {
            return empDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Emp> getPage(String current) {
        try {
            int currentPage = 1;    //初始数据，默认第1页
            int pageSize = 5;       //页大小，默认5条

            if (current != null) {  //为null默认第一页
                currentPage = Integer.parseInt(current);
            }
            Page page = new Page<>(currentPage, pageSize);
            long totalCount = empDao.getEmpCounts(); //获取总条数
            page.setTotalCount(totalCount); //设置总条数

            long pageCount = (long) Math.ceil((double)totalCount/pageSize);//设置总页数，向上取整（三元运算符也可以实现）
            page.setPageCount(pageCount);

            int startIndex = (currentPage-1)*pageSize;  //求起始页
            List<Emp> e = empDao.selectEmpsPage(startIndex, pageSize); //Dao层实现分页
            page.setList(e);

            return page;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
