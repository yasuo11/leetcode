package array;

public class Problem_80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] == nums[j])
            {
                nums[++i] = nums[j];
                while(j + 1 < nums.length && nums[j+1] == nums[i])
                    j++;
            }else
                nums[++i] = nums[j];
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4};
        int res = new Problem_80().removeDuplicates(nums);
        for(int i = 0; i < res; i++)
            System.out.print(nums[i] + " ");
    }
}
