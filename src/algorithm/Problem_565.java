package array;

import java.util.HashSet;
import java.util.Set;

public class Problem_565 {
    public int arrayNesting(int[] nums) {
        int max = 1;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(max > nums.length/2)
                return max;
            if(visited[nums[i]])
                continue;
            visited[nums[i]] = true;
            int curMax = 1;
            int cur = nums[nums[i]];
            while(nums[i] != cur){
                visited[cur] = true;
                curMax++;
                cur = nums[cur];
            }
            max = curMax > max? curMax : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {5,4,0,3,1,6,2};
        System.out.println(new Problem_565().arrayNesting(A));
    }
}
