package algorithm;

public class Problem_287 {
    public int findDuplicate(int[] nums) {
        int start = 1; int end = nums.length;
        while(start <= end){
            int mid = (end - start)/2 + start;
            int count = countRange(nums, start, mid);
            if(start == end)
                return start;
            if(count > mid - start + 1)
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    private int countRange(int[] nums, int start, int end){
        int count = 0;
        for(int n : nums)
            if(n >= start && n <= end)
                count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new Problem_287().findDuplicate(nums));
    }
}
