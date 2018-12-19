package algorithm;

public class Problem_12 {
    public String intToRoman(int num) {
        int bits = 0;
        int cur = num;
        while(cur > 0){
            bits++;
            cur = cur / 10;
        }
        int[] nums = new int[bits];
        for(int i = bits-1; i >= 0; i--){
            nums[i] = num % 10;
            num /= 10;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            if(bits - i == 4){
                while (nums[i] > 0)
                {
                    res.append("M");
                    nums[i]--;
                }
            }
            else if(bits - i == 3){
                if(nums[i] == 4){
                    res.append("CD");
                }else if(nums[i] == 9)
                    res.append("CM");
                else {
                    if(nums[i] >= 5){
                        res.append("D");
                        nums[i] -= 5;
                    }
                    while (nums[i] > 0){
                        res.append("C");
                        nums[i]--;
                    }
                }
            }
            else if(bits - i == 2){
                if(nums[i] == 4){
                    res.append("XL");
                }else if(nums[i] == 9)
                    res.append("XC");
                else {
                    if(nums[i] >= 5){
                        res.append("L");
                        nums[i] -= 5;
                    }
                    while (nums[i] > 0){
                        res.append("X");
                        nums[i]--;
                    }
                }
            }
            else if(bits - i == 1){
                if(nums[i] == 4){
                    res.append("IV");
                }else if(nums[i] == 9)
                    res.append("IX");
                else {
                    if(nums[i] >= 5){
                        res.append("V");
                        nums[i] -= 5;
                    }
                    while (nums[i] > 0){
                        res.append("I");
                        nums[i]--;
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem_12().intToRoman(4));
    }
}
