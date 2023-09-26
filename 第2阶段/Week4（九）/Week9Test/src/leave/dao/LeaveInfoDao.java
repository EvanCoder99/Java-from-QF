package leave.dao;

import leave.entity.LeaveInfo;

import java.sql.SQLException;
import java.util.List;

public interface LeaveInfoDao {
    public int add(LeaveInfo info) throws SQLException;
    public List<LeaveInfo> queryAll() throws SQLException;

    int delete(int id) throws SQLException;
}
