package com.cheerway.leetcode;

/**
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-09  18:40
 */
public class LC_50 {

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x,N) : 1.0/quickMul(x,-N);
    }

    public static void main(String[] args) {
        //Math.pow();
    }
}
