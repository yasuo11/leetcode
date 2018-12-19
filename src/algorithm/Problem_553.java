package algorithm;

public class Problem_553 {
    public String optimalDivision(int[] nums) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            res.append(nums[i]);
            if(i == nums.length-1)
            {
                if(nums.length >= 3)
                    res.append(")");
            }
            else {
                res.append("/");
                if(i == 0 && nums.length >= 3)
                    res.append("(");
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1000, 100, 2, 5, 4};
        System.out.println(new Problem_553().optimalDivision(nums));
    }
}
