package leave.service;

import leave.dao.LeaveInfoDao;
import leave.dao.impl.LeaveInforDaoImpl;
import leave.entity.LeaveInfo;

import java.sql.SQLException;
import java.util.List;

public class LeaveInfoService {
    private LeaveInfoDao leaveInfoDao = new LeaveInforDaoImpl();

    public List<LeaveInfo> showLeaveInfo() {
        try {
            List<LeaveInfo> leaveInfos = leaveInfoDao.queryAll();
            return leaveInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addLeaveInfo(LeaveInfo info) {
        try {
            return leaveInfoDao.add(info);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteLeaveInfo(int id) {
        String sql = "delete from leave_info where id=?";
        try {
            return leaveInfoDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
