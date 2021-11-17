package com.atguigu.io;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-11-15 17:38
 *
 * 文件读入到内存
 */
public class ioTest {
    // 文件读入到内存
    @Test
    public void tets01()
    {
        //如果文件不存在 就完蛋了
        File file = new File("hello.txt");

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            while((len=fileReader.read(cbuf))!=-1)
            {
                for(int i = 0;i<len;i++)
                {
                    System.out.print(cbuf[i]);
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally {
            if(fileReader!=null)
            {

                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02()
    {
        //文件的写入

        File file = new File("Hello2.txt");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("I have a dream\n");
            fileWriter.write("We should have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter!=null)
            {

                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void test04()
    {
        File file = new File("hello.txt");
        File file1 = new File("hello3.txt");

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);
            int len;
            char[] cbuf = new char[5];
            while((len = fileReader.read(cbuf))!=-1)
            {
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader!= null)
            {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fileWriter!=null)
            {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}
