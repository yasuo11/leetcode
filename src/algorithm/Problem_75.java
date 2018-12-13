package algorithm;

import java.util.Arrays;

public class Problem_75 {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = -1; int r = nums.length;
        while(i < r){
            if(nums[i] == 0)
                swap(nums, ++l, i++);
            else if(nums[i] == 2)
                swap(nums, --r, i);
            else
                i++;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,0,2,1,1,0,0};
        new Problem_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
