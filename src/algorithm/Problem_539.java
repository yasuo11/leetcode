package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size(); i++){
            String[] curTime;
            String[] preTime;
            if(i == 0) {
                preTime = timePoints.get(i).split(":");
                curTime = timePoints.get(timePoints.size()-1).split(":");
            }
            else {
                preTime = timePoints.get(i-1).split(":");
                curTime = timePoints.get(i).split(":");
            }
            int curHour = Integer.parseInt(curTime[0]), curMinutes = Integer.parseInt(curTime[1]);
            int preHour = Integer.parseInt(preTime[0]), preMinutes = Integer.parseInt(preTime[1]);
            int way1 = Math.abs(60 * curHour + curMinutes  - 60 * preHour - preMinutes);
            int way2 = Math.abs(60 * (23 - curHour) + 60 - curMinutes + 60 * preHour + preMinutes);
            res = Math.min(res, Math.min(way1, way2));
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:35"); timePoints.add("22:08"); timePoints.add("05:31");
        System.out.println(new Problem_539().findMinDifference(timePoints));
    }
}
