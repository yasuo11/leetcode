package algorithm;

public class Problem_537 {
    public String complexNumberMultiply(String a, String b) {
        int[] nums1 = parseToInt(a);
        int[] nums2 = parseToInt(b);
        int m = nums1[0] * nums2[0] - (nums1[1] * nums2[1]);
        int n = nums1[0] * nums2[1] + nums1[1] * nums2[0];
        return m + "+" + n + "i";
    }

    private int[] parseToInt(String cur){
        int[] nums = new int[2];
        int i = 0;
        int k = 0;
        while(i < cur.length()-1){
            char op = cur.charAt(i);
            if(op == '-')
                i++;
            int j = i;
            while(j < cur.length()-1 && cur.charAt(j) != '+')
                j++;
            nums[k] = Integer.parseInt(cur.substring(i, j));
            nums[k] = op == '-'? -nums[k] : nums[k];
            k++;
            i = ++j;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_537().complexNumberMultiply("1+0i", "1+0i"));
    }
}
