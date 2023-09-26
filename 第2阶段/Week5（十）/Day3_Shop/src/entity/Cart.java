package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

  private long c_id;  //购物车ID
  private long u_id;  //用户ID
  private long p_id;  //商品ID
  private BigDecimal c_count;   //商品小计
  private long c_num;   //商品数量

}
