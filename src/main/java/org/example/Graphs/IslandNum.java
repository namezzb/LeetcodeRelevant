package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandNum {
    public static int[][] moveArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int i1 = numIslands(grid);
        int i2 = numIslands(grid2);
        System.out.println(i1 + " " + i2);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // 使用DFS计算岛屿数量
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && (grid[i][j] == '1')){
                    count++;
                    // 注意：不需要在这里设置visited[i][j] = true，
                    // 因为dfs的第一步就是设置它。
                    dfs(visited, grid, i, j);
                }
            }
        }
        /*
        // 使用BFS计算岛屿数量
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && (grid[i][j] == '1')){
                    count++;
                    visited[i][j] = true;
                    bfs(visited, grid, i, j);
                }
            }
        }
        */
        return count;
    }
    public static void dfs(boolean[][] visited, char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0'){
            return;
        }

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nextX = moveArr[i][0] + x;
            int nextY = moveArr[i][1] + y;
            dfs(visited, grid, nextX, nextY);
        }
    }
    public static void bfs(boolean[][] visited, char[][] grid, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] curArr = queue.poll();
            int curX = curArr[0];
            int curY = curArr[1];
            for(int i = 0; i < 4; i++){
                int nextX = moveArr[i][0] + curX;
                int nextY = moveArr[i][1] + curY;
                if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
                    continue;
                }
                if(!visited[nextX][nextY] && grid[nextX][nextY] == '1'){
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
    