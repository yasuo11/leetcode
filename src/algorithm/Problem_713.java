package algorithm;

public class Problem_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)
            return 0;
        int sum = 1, i = 0, j = 0, res = 0;
        while(j < nums.length){
            if(nums[j] >= k)
            {
                i = ++j;
                continue;
            }
            sum *= nums[j];
            while(sum >= k)
                sum /= nums[i++];
            res += j - i + 1;
            j++;
        }
        return res;
    }
}
