package algorithm;

import java.util.Arrays;

public class Problem_667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        int cur = 1;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        visited[0] = true;
        for(int i = k; i > 0; i--){
            if((cur & 1) == 1)
                res[cur] = res[cur-1] + i;
            else
                res[cur] = res[cur-1] - i;
            visited[res[cur++]] = true;
        }
        for(int j = cur; j < n; j++){
            for(int i = 1; i <= k; i++)
            {
                int num1 = res[j-1] + i;
                int num2 = res[j-1] - i;
                if(num1 <= n && !visited[num1]){
                    res[j] = num1;
                    visited[num1] = true;
                    break;
                }
                else if(num2 >= 1 && !visited[num2]){
                    res[j] = num2;
                    visited[num2] = true;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem_667().constructArray(89, 15)));
    }
}
