package algorithm;

public class Problem_59 {
    public int[][] generateMatrix(int n) {
        if(n == 0)
            return null;
        int[][] res = new int[n][n];
        int startX = 0; int startY = 0;
        int endX = n-1; int endY = n-1;
        int cur = 1;
        while(startX <= endX && startY <= endY){
            if(startX == endX){
                for(int j = startY; j <= endY; j++)
                    res[startX][j] = cur++;
                return res;
            }
            if(startY == endY){
                for(int i = startX; i <= endX; i++)
                    res[i][startY] = cur++;
                return res;
            }
            for(int j = startY; j <= endY; j++)
                res[startX][j] = cur++;
            for(int i = startX+1; i < endX; i++)
                res[i][endY] = cur++;
            for(int j = endY; j >= startY; j--)
                res[endX][j] = cur++;
            for(int i = endX-1; i > startX; i--)
                res[i][startY] = cur++;
            startX++; startY++;
            endX--; endY--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new Problem_59().generateMatrix(3);
        for(int[] num : matrix)
        {
            for(int n : num)
                System.out.print(n + " ");
            System.out.println();
        }
    }
}
