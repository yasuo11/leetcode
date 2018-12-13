package array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem_56 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
            return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            Interval pre = res.get(res.size()-1);
            if(pre.end > cur.start)
            {
                if(pre.end <= cur.end)
                    pre.end = cur.end;
            }
            else
                res.add(cur);
        }
        return res;
    }
}
