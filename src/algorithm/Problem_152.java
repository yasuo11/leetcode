package array;

public class Problem_152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int num1 = 1;   //最小负数
        int num2 = 1;   //最大非负数
        for (int num : nums) {
            if(num == 0){
                max = max > 0? max : 0;
                num1 = 1;
                num2 = 1;
            }
            else if(num < 0){
                int cur = num1 * num;
                if(cur < 0){
                    num1 = cur < num2*num? cur : num2*num;
                    num2 = 1;
                    max = max > num1? max : num1;
                }else {
                    num1 = num2 * num;
                    num2 = cur;
                    max = max > num2? max : num2;
                }
            }
            else{
                num2 = num * num2;
                num1 = num * num1;
                max = max > num2? max : num2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(new Problem_152().maxProduct(nums));
    }
}
