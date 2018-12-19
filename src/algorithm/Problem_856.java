package algorithm;

public class Problem_856 {
    public int scoreOfParentheses(String S) {
        return f(S, 0, S.length()-1);
    }

    private int f(String S, int start, int end) {
        if(end - start == 1)
            return 1;
        int i = start;
        int res = 0;
        while (i <= end) {
            int j = i++;
            int left = 1;
            while(left > 0) {
                char c = S.charAt(i++);
                if(c == '(')
                    left++;
                else
                    left--;
            }
            if(i - j == 2)
                res ++;
            else
                res += 2 * f(S, j+1, i-2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_856().scoreOfParentheses("(()(()))"));
    }
}
