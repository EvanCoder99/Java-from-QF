package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

  private int i_id;    //详情ID
  private String o_id;  //订单ID
  private int p_id;    //商品id
  private BigDecimal i_count; //详情小计
  private int i_num;   //详情数量

  private Product goods;  //详情中包含商品属性
}
