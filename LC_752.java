package com.cheerway.leetcode;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-07  21:24
 */
public class LC_752 {
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        //这个集合记录我们访问过的密码，防止重复访问
        //将deadends直接加入visited就可以避免死锁，同时还省的维护deadends了（想的挺美，不知道为什么不行）
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                //跳过访问过的点
                if (deads.contains(curr)) {
                    continue;
                }
                //判断是否到达终点
                if (target.equals(curr)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    assert curr != null;
                    String up = plusOne(curr, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
