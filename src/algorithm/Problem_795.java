package array;

public class Problem_795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i = 0, j = 0;
        int maxIndex = 0;
        int res = 0;
        while(j < A.length){
            if(A[j] >= A[maxIndex]){
                if(A[j] < L)
                {
                    maxIndex = j;
                    j++;
                }
                else if(A[j] > R){
                    j = j+1;
                    i = j;
                    maxIndex = j;
                }
                else {
                    res += j - i + 1;
                    maxIndex = j++;
                }
            }else {
                if(A[j] >= L && A[j] <= R)
                {
                    res += j - i + 1;
                    maxIndex = j;
                }
                else if(A[maxIndex] >= L && A[maxIndex] <= R)
                    res += maxIndex - i + 1;
                j++;
            }
        }
        return res;
    }

    public int numSubarrayBoundedMax2(int[] A, int L, int R) {
        int res = 0;
        int i = 0, j = 0, maxIndex = 0;
        while(j < A.length){
            if(A[j] >= L && A[j] <= R)
            {
                res += j - i + 1;
                maxIndex = j;
            }
            else if(A[j] > R){
                i = j+1;
                maxIndex = j+1;
            }else{
                if(A[maxIndex] >= L && A[maxIndex] <= R)
                    res += maxIndex - i + 1;
                maxIndex = A[j] >= A[maxIndex]? j : maxIndex;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {73,55,36,5,55,14,9,7,72,52};
        System.out.println(new Problem_795().numSubarrayBoundedMax2(A, 32, 69));
    }
}
