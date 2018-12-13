package algorithm;

import java.util.Arrays;

public class Problem_31 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length-2; i >= 0; i--){
            int minBig = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] <= nums[i])
                    continue;
                if(minBig == i || nums[j] < nums[minBig])
                    minBig = j;
            }
            if(minBig != i && nums[i] != nums[minBig])
            {
                swap(nums, i, minBig);
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new Problem_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
