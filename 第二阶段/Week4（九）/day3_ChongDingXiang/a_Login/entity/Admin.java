package day3_ChongDingXiang.a_Login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
  private String username;
  private String phone;
  private String password;
  private String address;
}
