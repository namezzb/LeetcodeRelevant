package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSquareIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int maxArea = maxAreaOfIsland(grid);
        System.out.println("Max area of island is: " + maxArea);
    }
    public static int[][] moveArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int count;

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    dfs(visited, grid, i, j);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

    public static void dfs(boolean[][] visited, int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0){
            return;
        }
        visited[x][y] = true;
        count++;
        for(int i = 0; i < 4; i++){
            int nextX = moveArr[i][0] + x;
            int nextY = moveArr[i][1] + y;
            dfs(visited, grid, nextX, nextY);
        }
    }

    public static void bfs(boolean[][] visited, int[][] grid, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
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
                if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}

