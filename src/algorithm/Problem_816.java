package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_816 {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length()-1; ++i)
            for (String left: make(S, 1, i))
                for (String right: make(S, i, S.length()-1))
                    ans.add("(" + left + ", " + right + ")");
        return ans;
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = S.substring(i, i+d);
            String right = S.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem_816().ambiguousCoordinates("(0123)").toArray()));
    }
}
