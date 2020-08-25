package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-24  21:57
 */
public class LC_231 {
    //x 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
    //1. 恒有 n & (n - 1) == 0，这是因为：
    //   nn 二进制最高位为 11，其余所有位为 00；
    //   n - 1n−1 二进制最高位为 00，其余所有位为 11；
    //2. 一定满足 n > 0。

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
