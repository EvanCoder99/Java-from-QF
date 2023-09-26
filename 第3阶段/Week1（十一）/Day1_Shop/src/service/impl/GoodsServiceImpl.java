package service.impl;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import entity.Page;
import entity.Product;
import service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<Product> showByTid(int tid) {
        try {
            return goodsDao.selectById(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Product> getPage(int tid, String current) {
        int currentPage = 1;
        int pageSize = 4;

        if (current != null) {
            currentPage = Integer.parseInt(current);//当前页赋值
        }

        Page<Product> page = new Page<>(currentPage, pageSize);
        try {
            //设置总条数
            long totalCount = goodsDao.getTotalCount(tid);
            page.setTotalCount(totalCount);

            //设置总页数，总条数 % 每页条数 == 0 ？
            long pageCount = (totalCount % pageSize == 0) ? totalCount/pageSize : totalCount/pageSize+1;
            page.setPageCount(pageCount);

            //求起始行
            int startIndex = (currentPage-1)*pageSize;
            page.setList(goodsDao.selectByPage(startIndex,pageSize,tid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public Product showByPid(int pid) {
        try {
            return goodsDao.selectByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
