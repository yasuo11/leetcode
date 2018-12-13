package algorithm;

import java.util.Arrays;

public class Problem_945 {
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0)
            return 0;
        Arrays.sort(A);
        int res = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1])
                continue;
            res += A[i-1] - A[i] + 1;
            A[i] = A[i-1] + 1;
        }
        return res;
    }
}
