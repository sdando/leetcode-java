package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import leetcode.Insert_Interval.Interval;

public class Merge_Intervals extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	
	class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval a,Interval b){
			if(a.start==b.start) return 0;
			else if(a.start<b.start) return -1;
			else return 1;
		}
	}
	//逐一归并，若归并不了，则加入。
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if(intervals.size()<2) return intervals;
    	ArrayList<Interval> ret=new ArrayList<Interval>();
    	Collections.sort(intervals, new IntervalComparator());
    	Interval cur,newInterval=intervals.get(0);
    	for(int i=1;i<intervals.size();i++){
    		cur=intervals.get(i);
    		if(cur.start<=newInterval.end){
    			if(cur.end>newInterval.end)
    			    newInterval.end=cur.end;
    		}
    		else {
				ret.add(newInterval);
				newInterval=cur;
			}
    	}
    	ret.add(newInterval);
    	return ret;
    }
}
