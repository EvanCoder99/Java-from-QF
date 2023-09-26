package day4_DAO.c_ORM;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //生成了set/get  toString
@NoArgsConstructor  //无参构造
@AllArgsConstructor //全参构造
public class c_Jobs {   //实体类  属性与表字段一致
    private String job_id;
    private  String job_title;
    private  String min_salary;
    private  String max_salary;
}
