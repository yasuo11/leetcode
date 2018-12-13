package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int startX = 0; int startY = 0;
        int endX = m-1; int endY = n-1;
        while(startX <= endX && startY <= endY){
            if(startX == endX){
                for(int j = startY; j <= endY; j++)
                    res.add(matrix[startX][j]);
                return res;
            }
            if(startY == endY){
                for(int i = startX; i <= endX; i++)
                    res.add(matrix[i][startY]);
                return res;
            }
            for(int j = startY; j <= endY; j++)
                res.add(matrix[startX][j]);
            for(int i = startX+1; i < endX; i++)
                res.add(matrix[i][endY]);
            for(int j = endY; j >= startY && startX != endX; j--)
                res.add(matrix[endX][j]);
            for(int i = endX-1; i > startX; i--)
                res.add(matrix[i][startY]);
            startX++; startY++;
            endX--; endY--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},
                {2},
                {3}};
        System.out.println(Arrays.toString(new Problem_54().spiralOrder(matrix).toArray()));
    }
}
