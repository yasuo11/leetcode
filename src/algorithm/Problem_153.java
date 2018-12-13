package algorithm;

public class Problem_153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            if(right - left <= 1)
                return Math.min(nums[left], nums[right]);
            int mid = (right - left)/2 + left;
            if(nums[mid] > nums[left] && nums[mid] < nums[right])
                return nums[left];
            if(nums[mid] > nums[left])
                left = mid+1;
            else if(nums[mid] < nums[left])
                right = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2};
        System.out.println(new Problem_153().findMin(nums));
    }
}
