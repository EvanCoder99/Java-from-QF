package leave.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveInfo {

  private long id;
  private String user_id;
  private String content;
  private java.util.Date starttime;
  private java.util.Date endtime;
  private long status;
  private String name;

}
