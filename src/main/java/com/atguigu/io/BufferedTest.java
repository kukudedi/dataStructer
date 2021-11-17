package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-11-15 19:58
 *
 * 缓冲流意义  提高效率
 */
public class BufferedTest {

    @Test
    public void text01()
    {
        long l = System.currentTimeMillis();
        File file1 = new File("C:\\Users\\di\\Desktop\\1.pdf");
        File file2 = new File("C:\\Users\\di\\Desktop\\2.pdf");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            bufferedInputStream = new BufferedInputStream(fis);
            bufferedOutputStream = new BufferedOutputStream(fos);

            byte[] bytes= new byte[1000];
            int len;
            while((len = bufferedInputStream.read(bytes))!=-1)
            {
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bufferedInputStream != null)
            {

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        long end = System.currentTimeMillis();
        System.out.println(end-l);

    }


}
