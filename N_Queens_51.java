package com.cheerway.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-01  20:26
 */
public class N_Queens_51 {

    private List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return res;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row+1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // 检查竖直方向
        for (char[] chars : board) if (chars[col] == 'Q') return false;

        //正反对角线方向上的检查，即看x，y轴两个方向的距离是否一样
        int flag = 0;
        for (char[] chars : board) {
            for (int i = 0; i < chars.length; i++) {
                if (flag >= row) return true;
                if (chars[i] == 'Q' && (row - flag) == Math.abs(i-col)) return false;
            }
            flag++;
        }
        return true;
    }

    public static void main(String[] args) {
        new N_Queens_51().solveNQueens(4);
    }
}
