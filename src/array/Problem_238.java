package array;

import java.util.Arrays;

public class Problem_238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1)
            throw new IllegalArgumentException("参数异常~~");
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < res.length; i++)
            res[i] = res[i-1] * nums[i-1];
        int right = 1;
        for(int j = res.length-2; j >= 0; j--)
        {
            right *= nums[j+1];
            res[j] = res[j] * right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new Problem_238().productExceptSelf(nums)));
    }
}
