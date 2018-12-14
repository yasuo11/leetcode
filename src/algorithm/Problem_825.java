package algorithm;

public class Problem_825 {
    public int numFriendRequests(int[] ages) {
        int[] fre = new int[121];
        for(int age : ages)
            fre[age]++;
        int res = 0;
        for(int i = 1; i <= 120; i++){
            for(int j = i; j >= 1; j--){
                if(i < 100 && j > 100 || j <= 0.5 * i + 7)
                    continue;
                if(i == j){
                    res += fre[i] * (fre[i]-1);
                    continue;
                }
                res += fre[i] * fre[j];
            }
        }
        return res;
    }
}
