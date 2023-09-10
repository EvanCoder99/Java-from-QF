package day7.yuanawen;

import java.util.List;

public class DaoImpl {
    public int add(Student s){
        String sql = "insert into student (name,age,stno) values(?,?,?)";
        return DaoUtils.Update(sql,s.getName(),s.getAge(),s.getStno());
    }

    public List<Student> query(){
        String sql = "select * from student";
        return DaoUtils.Query(sql,Student.class);
    }
}
