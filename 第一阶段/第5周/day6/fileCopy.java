package week5.day6;

import java.io.*;

public class fileCopy {
    public static void main(String[] args) {
        File srcFile = new File("e:\\test");
        String dest = "f:\\";
        File destFile = new File(dest);

        copyDir(srcFile,destFile);

    }
    public static void copyDir(File srcFile, File destFile){
        if (srcFile.isFile()) {  //是文件则递归结束，并且复制文件过去
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                //1、文件复制
                fis = new FileInputStream(srcFile);//
                fos = new FileOutputStream("");
                byte[] b = new byte[1024];

                int len = 0;
                //2、边读边写
                while ((len = fis.read(b)) != -1)
                    fos.write(b,0,len);

                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null)
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            return;
        }
        File[] fs = srcFile.listFiles();//获取子目录
        for (File f : fs) {
            if (f.isDirectory()){
                String srcDir = f.getAbsolutePath();
                String destDir = destFile.getAbsolutePath() + srcDir.substring(3);
                File newfile = new File(destDir);
                if (!newfile.exists()){ //目录不存在
                    newfile.mkdirs();
                }
            }
            copyDir(f,destFile);
        }
    }
}
