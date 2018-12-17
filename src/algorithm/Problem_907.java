package algorithm;

import java.util.Stack;

public class Problem_907 {
    public int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[] {A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[] {A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }

    public int sumSubarrayMins2(int[] A) {
        int n = A.length;
        int[] lBigIndex = new int[n];
        int[] rBigIndex = new int[n];
        for (int i = 0; i < n; i++) {
            lBigIndex[i] = i;
            int j = i - 1;
            while (j >= 0 && A[j] >= A[i]) {
                lBigIndex[i] = lBigIndex[j];
                j = lBigIndex[j] - 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            rBigIndex[i] = i;
            int j = i + 1;
            while (j < n && A[j] > A[i]) {
                rBigIndex[i] = rBigIndex[j];
                j = rBigIndex[j] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (i - lBigIndex[i] + 1) * (rBigIndex[i] - i + 1) * A[i];
            sum %= 1000000007;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] A = {48, 87, 27};
        System.out.println(new Problem_907().sumSubarrayMins(A));
    }
}
