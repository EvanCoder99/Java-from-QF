package emp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
从后端回传到前端的数据有很多，
例如：内容，当前页，页数量等，
所以需要封装成Page实体类，将这些数据装起来。
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page <T>{
    private int currentPage;    //当前页
    private int pageSize;   //每条页数
    private long totalCount;    //总条数，因为数据库查询结果是long类型
    private long pageCount;     //总页数
    private List<T> list;   //存内容

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
