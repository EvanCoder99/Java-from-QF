package day7.yuanawen;


import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public void pandaun(Student s) {
        DaoImpl dao = new DaoImpl();
        List<Student> list = new ArrayList<>();

        try {
            DBUtils.begin();
            list = dao.query();
            for (Student ss : list) {
                if (ss.getStno().equals(s.getStno()))
                    throw new RuntimeException("学号已存在");
            }
            System.out.println("添加记录："+dao.add(s));
            DBUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.rollback();
        }
    }
}
