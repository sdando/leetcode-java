package leetcode;

import java.util.ArrayList;

public class Insert_Interval extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret=new ArrayList<Interval>();
        int n=intervals.size();
        int i=0;
        while(i<n&&intervals.get(i).end<newInterval.start){
        	ret.add(intervals.get(i));
        	i++;
        }
        while(i<n&&intervals.get(i).start<=newInterval.end){
        	newInterval.start=Math.min(intervals.get(i).start, newInterval.start);
        	newInterval.end=Math.max(intervals.get(i).end, newInterval.end);
        	i++;
        }
        ret.add(newInterval);
        while(i<n){
        	ret.add(intervals.get(i));
        	i++;
        }
        return ret;
    }
}
