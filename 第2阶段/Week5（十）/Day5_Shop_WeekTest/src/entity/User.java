package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int u_id;
  private String u_name;
  private String u_password;
  private String u_email;
  private String u_sex;
  private int u_status;  //用户激活状态
  private String u_code;  //激活码
  private int u_role;    //用户角色
}
