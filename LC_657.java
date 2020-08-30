package com.cheerway.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-28  20:13
 */
public class LC_657 {

    public boolean judgeCircle(String moves) {
        int row = 0, col = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') row++;
            else if (c == 'D') row--;
            else if (c == 'L') col--;
            else col++;
        }
        return col == 0 && row == 0;
    }

}