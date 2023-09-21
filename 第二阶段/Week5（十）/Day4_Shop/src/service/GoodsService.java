package service;

import entity.Page;
import entity.Product;

import java.util.List;

public interface GoodsService {
    List<Product> showByTid(int tid);
    Page<Product> getPage(int tid, String current);

    Product showByPid(int pid);
}
