package algorithm;

import java.util.Arrays;

public class Problem_611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                continue;
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i] + nums[j] <= nums[k] || nums[k] - nums[i] >= nums[j])
                        break;
                    res++;
                }
            }
        }
        return res;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                continue;
            int j = i+1;
            int k = nums.length-1;
            while(k > i+1)
            {
                if(nums[i] + nums[j] > nums[k] && nums[k] - nums[i] < nums[j])
                {
                    res += k - j;
                    k--;
                    j = i+1;
                }
                else {
                    if (j + 1 >= k) {
                        k--;
                        j = i + 1;
                    }else
                        j++;
                }
            }
        }
        return res;
    }

    public int triangleNumber3(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(new Problem_611().triangleNumber3(nums));
    }
}
