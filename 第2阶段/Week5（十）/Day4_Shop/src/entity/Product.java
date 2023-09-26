package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private int p_id;       //商品id
  private int  t_id;      //类别id
  private String p_name;  //商品名
  private Date p_time;    //上架时间
  private String p_image; //图片
  private BigDecimal p_price; //价格
  private int p_state;    //状态
  private String p_info;

}
