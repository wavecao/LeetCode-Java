package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-22  20:36
 */
public class LC_679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }

        return resolve(list);
    }

    private boolean resolve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0)) - 24 < 1e-6;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> copy = new ArrayList<>(list);
                // 不能先获取a，因为a在b前面，把a移除后，b的位置会变化
                double b = copy.remove(j);
                double a = copy.remove(i);
                boolean valid = false;
                copy.add(a+b);
                valid |= resolve(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= resolve(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= resolve(copy);
                if (b != 0) {
                    copy.set(copy.size() - 1, a / b);
                    valid |= resolve(copy);
                }
                copy.set(copy.size() - 1, b - a);
                valid |= resolve(copy);
                if (a != 0) {
                    copy.set(copy.size() - 1, b / a);
                    valid |= resolve(copy);
                }
                if (valid) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((double) 1e-6);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.remove(2));
        System.out.println();
    }
}
