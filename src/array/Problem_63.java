package array;

public class Problem_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int j = 0; j < n; j++)
        {
            if(obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i++)
        {
            if(obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
}
