package array;

public class Problem_162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (r - l) / 2 + l;
            if((mid <= l || nums[mid] > nums[mid-1]) &&
                    (mid >= r || nums[mid] > nums[mid+1]))
                return mid;
            if(mid <= l || nums[mid] > nums[mid-1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(new Problem_162().findPeakElement(nums));
    }
}
