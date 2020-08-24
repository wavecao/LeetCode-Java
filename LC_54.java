package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-20  21:53
 */
public class LC_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        //从外部向内部遍历，逐层打印数据
        while(i < count) {
            //打印行
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            //打印列
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][n-i-1]);
            }
            //倒过来打印行, n-1是列下标，i+1是层数+1，+1是因为行列重叠的值被上个循环打印过了
            //如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即 （m-1-i ）!= i
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 -i) != i; j--) {
                list.add(matrix[m-1-i][j]);
            }
            //倒过来打印竖列, m-1是行下标， i+1是层数+1，+1是因为行列重叠的值被上个循环打印过了
            //这里j >= i + 1 而不是上个循环的i是因为左上角的元素被打印过了
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 -i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
