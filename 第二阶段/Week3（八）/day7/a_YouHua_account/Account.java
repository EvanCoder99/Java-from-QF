package day7.a_YouHua_account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String cart;
    private String password;
    private int money;
}
