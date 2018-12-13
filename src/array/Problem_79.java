package array;

public class Problem_79 {
    private int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private boolean[][] visited;
    private int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(dfs(board, word, 0, i, j))
                    return true;
        return false;
    }
    private boolean dfs(char[][] board, String word, int cur, int startX, int startY){
        if(cur >= word.length())
            return true;
        if(cur == word.length()-1 && board[startX][startY] == word.charAt(cur))
            return true;
        if(board[startX][startY] != word.charAt(cur))
            return false;
        visited[startX][startY] = true;
        for(int i = 0; i < 4; i++){
            int newX = startX + d[i][0];
            int newY = startY + d[i][1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY])
                if(dfs(board, word, cur+1, newX, newY))
                    return true;
        }
        visited[startX][startY] = false;
        return false;
    }
}
