package array;

public class Problem_695 {
    private int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
    private int m,n;
    private boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int max = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        return max;
    }
    private int dfs(int[][] grid, int x, int y){
        if(visited[x][y])
            return 0;
        int res = 1;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n &&
                    !visited[newX][newY] && grid[newX][newY] == 1)
                res += dfs(grid, newX, newY);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
        System.out.println(new Problem_695().maxAreaOfIsland(grid));
    }
}
