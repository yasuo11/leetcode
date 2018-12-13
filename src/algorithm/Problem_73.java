package algorithm;

import java.util.Arrays;

public class Problem_73 {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0)
            return;
        Integer zeroRow = null;
        Integer zeroCol = null;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0)
                    continue;
                if(zeroRow == null){
                    zeroRow = i;
                    zeroCol = j;
                }else {
                    matrix[i][zeroCol] = 0;
                    matrix[zeroRow][j] = 0;
                }
            }
        }
        if(zeroRow == null)
            return;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][zeroCol] == 0 && i != zeroRow)
                for(int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[zeroRow][j] == 0 && j != zeroCol)
                for(int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
        }
        for(int i = 0; i < matrix.length; i++)
            matrix[i][zeroCol] = 0;
        for(int j = 0; j < matrix[0].length; j++)
            matrix[zeroRow][j] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 0, 5}};
        new Problem_73().setZeroes(matrix);
        for(int n[] : matrix)
            System.out.println(Arrays.toString(n));
    }
}
