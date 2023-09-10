package day7.c_DAOUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private  String name;
    private  int age;
    private Date bornDate; //java.util包下的日期类型
    private  String email;
}
