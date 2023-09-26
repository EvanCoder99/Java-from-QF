package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

  private String o_id;      //订单ID
  private int u_id;         //用户ID
  private int a_id;         //地址id
  private BigDecimal o_count; //总金额
  private Date o_time;      //订单时间
  private int o_state;      //订单状态

  private Address address;  //每个订单中由一条地址信息
  private List<Item> list;  //订单里面包含详情集合

}
