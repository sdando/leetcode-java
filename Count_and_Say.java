package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Count_and_Say {
	
	@Test
	public void test(){
		String ret=countAndSay(6);
		return;
	}
	
    public String countAndSay(int n) {
        String ret="";
        if(n==0)
        	return ret;
        String last="10";
        StringBuilder cur=new StringBuilder();
        int count;
        char lastSame,curCh;
        for(int i=1;i<n;i++){
        	count=1;
        	lastSame=last.charAt(0);
        	for(int j=1;j<last.length();j++){
        		curCh=last.charAt(j);
        		if(curCh!=lastSame){
        			cur.append(count);
        			cur.append(lastSame);
        			count=1;
        			lastSame=curCh;
        		}
        		else{
        		    count++;
        		}
        	}
        	last=new String(cur.toString()+"0");
        	cur.delete(0, cur.length());
        }
        return last.substring(0,last.length()-1);
    }
}
