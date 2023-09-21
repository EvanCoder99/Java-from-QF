package com.sample;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

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

}
