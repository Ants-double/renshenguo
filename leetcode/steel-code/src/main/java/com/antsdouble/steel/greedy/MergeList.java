package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class MergeList {
    public List<Interval> solution(List<Interval> intervals) {
        return getResult(intervals);
    }


    private List<Interval> getResult(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        intervals.sort((o1, o2) -> {
            if (o1.start > o2.start) {
                return 1;
            } else if (o1.start < o2.start) {
                return -1;
            }
            return 0;
        });
        List<Interval> list = new ArrayList<>();

        list.add(intervals.get(0));
        for (Interval i: intervals) {
            //是否进行合并
            boolean flag = false;
            for (Interval j : list) {
                int max = Math.max(i.end, j.end);
                int min = Math.min(i.start, j.start);
                if (max - min <= i.end - i.start + j.end - j.start) {
                    j.end = max;
                    j.start = min;
                    flag = true;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }
}
