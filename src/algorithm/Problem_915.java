package array;

public class Problem_915 {
    public int partitionDisjoint(int[] A) {
        int[] mins = new int[A.length];
        int min = A[A.length-1];
        mins[A.length-1] = min;
        for(int i = A.length-2; i >= 0; i--){
            min = A[i] < min? A[i] : min;
            mins[i] = min;
        }
        int max = A[0];
        for(int l = 1; l < A.length; l++){
            if(max <= mins[l])
                return l;
            max = A[l] > max? A[l] : max;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,6,12};
        System.out.println(new Problem_915().partitionDisjoint(A));
    }
}
