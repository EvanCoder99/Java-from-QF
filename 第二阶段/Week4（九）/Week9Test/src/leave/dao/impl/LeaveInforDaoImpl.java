package leave.dao.impl;

import leave.dao.LeaveInfoDao;
import leave.entity.LeaveInfo;
import leave.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

public class LeaveInforDaoImpl implements LeaveInfoDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);
    @Override
    public int add(LeaveInfo info) throws SQLException {
        String sql = "insert into leave_info(id,user_id,content,starttime,endtime,status,name) values(?,?,?,?,?,?,?)";
//        Date dateStart = new Date(info.getStarttime().getTime());
//        Date dateEnd = new Date(info.getEndtime().getTime());
        return runner.update(sql,info.getId(),info.getUser_id(),info.getContent(),info.getStarttime(),info.getEndtime(),info.getStatus(),info.getName());
    }

    @Override
    public List<LeaveInfo> queryAll() throws SQLException {
        String sql = "select * from leave_info";
        return runner.query(sql,new BeanListHandler<>(LeaveInfo.class));
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "delete from leave_info where id=?";
        return runner.update(sql,id);
    }

    public static void main(String[] args) throws SQLException {
        LeaveInforDaoImpl dao = new LeaveInforDaoImpl();
        LeaveInfo i1 = new LeaveInfo(3, "1", "病",new Date(),new Date(),0, "张三");

        System.out.println(dao.add(i1));
        System.out.println(dao.queryAll());
    }

}
