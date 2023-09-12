package day1_Servlet.c_Test.b_ORM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class entity {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String love;
}
