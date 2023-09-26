package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page <T>{
    private int currentPage;    //当前页
    private int pageSize;       //页大小，每页多少条数据
    private long totalCount;    //总条数
    private long pageCount;     //总页数
    private List<T> list;       //存内容

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
