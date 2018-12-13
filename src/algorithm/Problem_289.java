package algorithm;

public class Problem_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = 0;
                // 累加上下左右及四个角还有自身的值
                for(int y = Math.max(i - 1, 0); y <= Math.min(i + 1, m - 1); y++){
                    for(int x = Math.max(j - 1, 0); x <= Math.min(j + 1, n - 1); x++){
                        // 累加bit1的值
                        lives += board[y][x] & 1;
                    }
                }
                // 如果自己是活的，周边有两个活的，lives是3
                // 如果自己是死的，周边有三个活的，lives是3
                // 如果自己是活的，周边有三个活的，lives减自己是3
                if(lives == 3 || lives - board[i][j] == 3){
                    board[i][j] |= 2;
                }
            }
        }
        // 右移就是新的值
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>>= 1;
            }
        }
    }
}
