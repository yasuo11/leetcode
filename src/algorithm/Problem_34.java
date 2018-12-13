package algorithm;

public class Problem_34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, 0, nums.length-1, 0),
                search(nums, target, 0, nums.length-1, 1)};
    }
    private int search(int[] nums, int target, int lo, int hi, int flag){
        int l = lo;
        int r = hi;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(target < nums[mid])
                r = mid - 1;
            else if(target > nums[mid])
                l = mid + 1;
            else {
                if(flag == 0 && (mid <= l || nums[mid-1] < nums[mid]))
                    return mid;
                else if(flag == 0){
                    r = mid - 1;
                }
                if(flag == 1 && (mid >= r || nums[mid+1] > nums[mid]))
                    return mid;
                else if(flag == 1)
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int b = 5 - 3 >> 1;
        int a = 4 + (5 - 3) >> 1 + 4;
        System.out.println(b);
        System.out.println(a);
    }
}
