package week5.day1_IOStream.e_HSP;

import org.junit.Test;

import java.io.File;

public class test3 {
    //判断 e:\demo\a\b\c 是否存在，存在提示，不存在则创建
    @Test
    public void f1() {
        String dirPath = "e:\\demo\\a\\b\\c";
        File file = new File(dirPath);
        if (file.exists()) {
            System.out.println(dirPath + "存在");
        } else {
            System.out.println(dirPath + "不存在");
            if (file.mkdirs())
                System.out.println(dirPath + "创建成功");
            else
                System.out.println(dirPath + "创建失败");
        }
    }
}
