package array;

import java.util.Map;

public class Problem_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(r < nums.length){
            if(sum < s)
            {
                if(r == nums.length-1)
                    return res == Integer.MAX_VALUE? 0 : res;
                sum += nums[++r];
            }
            else if(sum >= s){
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Problem_209().minSubArrayLen(7, nums));
    }
}
