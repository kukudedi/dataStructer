package com.atguigu.parseArray;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-11-15 17:34
 */
public class parseArray {
    public static void main(String[] args) throws IOException {
        // 创建一个原始的二维数组 11 * 11
        System.out.println("hot_fix");
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        chessArr1[6][8] = 1;
        // 输出原始的二维数组
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.printf("%d\t", chessArr1[i][j]);
            }
            System.out.println();
        }
        //获取有效值数量
        int sum = 0;

        for (int[] row : chessArr1) {
            for (int num : row) {
                if (num != 0) {
                    sum++;
                }
            }
        }
        //建立sparseArray
        int[][] sparseArray = new int[sum + 1][3];
        //向sparseArray填入数值
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历原始数组  向sparsearrary中赋值
        int count = 0; //计数器
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("sparseArray为：");
        for (int[] row : sparseArray) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        /**
         * sparseArray
         *
         * IO
         */

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("parseArray.txt"));


        for (int[] row : sparseArray) {
            for (int num : row) {
                dataOutputStream.writeInt(num);
            }
        }
        int[][] chars = new int[sum + 1][3];
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("parseArray.txt"));
        for (int i = 0; i < sum + 1; i ++) {
            for (int j = 0; j < 3; j++) {
                chars[i][j] =dataInputStream.readInt();
            }
        }
        for(int[] row : chars)
        {
            for(int num : row)
            {
                System.out.print(num+"\t");
            }
            System.out.println();
        }
        /**
         * sparseArray
         *
         * IO
         */
        System.out.println("还原之后");
        System.out.println();
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];//还原之后的数组
        for (int i = 1; i < sum; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];

        }
        for (int[] row : chessArr2) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }


    }

}
