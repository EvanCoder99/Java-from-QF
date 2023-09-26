package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private int a_id;   //地址id
  private int u_id;   //用户id
  private String a_name;  //收货人
  private String a_phone; //手机号
  private String a_detail;  //收货地址
  private long a_state;   //收货状态  1-默认地址 0非默认

}
