package array;

public class Problem_55 {
    public boolean canJump(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length-1; i++){
            sum = Math.max(nums[i], sum);
            if(sum == 0)
                return false;
            if(sum >= nums.length - i - 1)
                return true;
            sum--;
        }
        return true;
    }
}
