package algorithm;

import java.util.Arrays;

public class Problem_81 {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    private boolean search(int[] nums, int left, int right, int target){
        if(left > right)
            return false;
        int mid = (right - left) / 2 + left;
        if(nums[mid] == target)
            return true;
        if(nums[left] < nums[mid] || nums[right] < nums[mid])
            return Arrays.binarySearch(nums, left, mid+1, target) >= 0 ||
                    search(nums, mid + 1, right, target);
        if(nums[mid] < nums[right] || nums[left] > nums[mid])
            return Arrays.binarySearch(nums, mid, right+1, target) >= 0 ||
                    search(nums, left, mid-1, target);
        if(nums[left] == nums[mid])
            return searchRange(nums, left, mid, target) || search(nums, mid + 1, right, target);
        if(nums[right] == nums[mid])
            return searchRange(nums, mid, right, target) || search(nums, left, mid-1, target);
        return false;
    }

    private boolean searchRange(int[] nums, int l, int r, int k){
        for(int i = l; i <= r; i++)
            if(nums[i] == k)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(Arrays.binarySearch(nums, 0, 2, 3));
        System.out.println(new Problem_81().search(nums, 3));
    }
}
