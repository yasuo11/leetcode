package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == nums[i] - 1)
                continue;
            if(nums[i] == nums[nums[i]-1])
                res.add(nums[i]);
            else if(i < nums[i] -1)
                swap(nums, i, nums[i--]-1);
            else
                swap(nums, i, nums[i]-1);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(new Problem_442().findDuplicates(nums).toArray()));
    }
}
