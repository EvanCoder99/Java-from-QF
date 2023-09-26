package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

  private int c_id;  //购物车ID
  private int u_id;  //用户ID
  private int p_id;  //商品ID
  private BigDecimal c_count;   //商品小计
  private int c_num;   //商品数量

  private Product goods;  //购物车商品，数据库内没有，主要针对前端展示的属性，ORM无法注入值，需手动注入

}
