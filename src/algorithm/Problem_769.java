package array;

public class Problem_769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int i = 0;
        while(i < arr.length){
            int j = i+1;
            int cur = -1;
            for(; j < arr.length; j++)
                if(arr[i] > arr[j])
                    cur = j;
            int maxIndex = i;
            for(int k = i+1; k < cur; k++)
                if(arr[maxIndex] < arr[k])
                    maxIndex = k;
            int k = cur+1;
            int m = -1;
            while(k < arr.length){
                if(arr[k] < arr[maxIndex])
                    m = k;
                k++;
            }
            i = cur == -1? i + 1 : Math.max(cur, m)+1;
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 0, 7, 8, 2, 5};
        System.out.println(new Problem_769().maxChunksToSorted(arr));
    }
}
