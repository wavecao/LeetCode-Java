package com.cheerway.leetcode;

import javafx.geometry.HorizontalDirection;

/**
 * <pre>
 *  [["5","3","1","2","7","6","5","9","4"],
 *   ["6","4","7","1","9","5","3","2","8"],
 *   ["2","9","8","3","4","2","5","6","7"],
 *   ["8","8","1","7","6","4","9","5","3"],
 *   ["4","2","6","8","5","3","7","9","1"],
 *   ["7","3","5","9","2","1","8","4","6"],
 *   ["5","6","9","5","3","7","2","8","4"],
 *   ["3","7","2","4","1","9","6","3","5"],
 *   ["1","5","4","2","8","6","1","7","9"]]
 * </pre>
 *
 * @author : 曹威
 * @since : 2020-08-02  19:29
 */
public class LC_37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != '.') {
            // 如果有预设数字，不用我们穷举
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 1; i < 9; i++) {
            if (board[row][i] == ch) return false;
            if (board[i][col] == ch) return false;
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == ch)
                return false;
        }
        return true;
    }
}
