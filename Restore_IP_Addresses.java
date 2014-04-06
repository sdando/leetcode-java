package leetcode;

import java.util.ArrayList;

public class Restore_IP_Addresses extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<String> ret=restoreIpAddresses("25525511135");
		return;
	}
    public ArrayList<String> restoreIpAddresses(String s) {
       ArrayList<String> ret=new ArrayList<String>();
       if(s==null||"".equals(s)) return ret;
       String one=new String();
       dfs(0, 0, s, one, ret);
       return ret;
    }
    //search state has tree(one char,two chars,three chars)
    //step represent i'th of ip
    private void dfs(int start,int step,String s,String one,ArrayList<String> ret){
    	int length=s.length();
    	if(start==length&&step==4){
    	    ret.add(one.substring(0, one.length()-1));
    	    return;
    	}
    	if(length-start>3*(4-step)) return;
    	if(length-start<4-step) return;
    	int num=0;
    	for(int i=start;i<start+3&&i<length;i++){
    		num=num*10+(s.charAt(i)-'0');
    		if(num<=255){			
    			dfs(i+1, step+1, s, one+String.valueOf(num)+".", ret);	
    		}
    		if(num==0) break;
    	}
    }
}
