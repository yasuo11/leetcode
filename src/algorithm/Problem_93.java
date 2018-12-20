package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return ret;
        bktrace(ret, s, "", 0, 0);
        return ret;
    }

    private void bktrace(List<String> ret, String s, String temp, int parts, int st) {
        if(parts > 4) return;
        if(parts == 4 && st == s.length()) {
            ret.add(temp);
            return;
        }
        for(int i = st+1; i <= s.length() && i<= st+3; ++i) {
            if(s.charAt(st) == '0') {
                bktrace(ret, s, temp + (parts == 3 ? 0 : 0+"."), parts+1, st+1);
                return;
            }
            String num = s.substring(st, i);
            if(Integer.parseInt(num) > 255) return;
            bktrace(ret, s, temp + num + (parts == 3 ? "" : "."), parts+1, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem_93().restoreIpAddresses("129000").toArray()));
    }
}
