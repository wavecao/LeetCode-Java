package com.cheerway.leetcode;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-31  9:12
 */
public class LC_841 {
    boolean[] visited;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        visited = new boolean[n];
        //dfs模拟的是访问某个房间
        dfs(rooms, 0);
        return num == n;
    }

    private int dfs(List<List<Integer>> rooms, int x) {
        //设置x号房间已经访问
        visited[x] = true;
        //访问的房间计数+1
        num++;
        //对该房间内的钥匙进行遍历
        for (int i : rooms.get(x)) {
            //如果钥匙对应的房间没有访问过，就访问
            if (!visited[i]) {
                dfs(rooms, i);
            }
        }
        return num;
    }
}
