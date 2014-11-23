package leetcode;

import junit.framework.Assert;

public class String_to_Integer extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(0, atoi("2147483648"));
	}
    public int atoi(String str) {
        String s=str.trim();
        if(s.length()==0) return 0;
        int ret=0;
        int start=0,sign=1;
        if(s.charAt(0)=='-'){
        	start=1;
        	sign=-1;
        }
        else if(s.charAt(0)=='+'){
        	start=1;
        }
        else if(s.charAt(0)<'0'||s.charAt(0)>'9'){
			    return 0;
		    }
        char ch;
        for(int i=start;i<s.length();i++){
        	ch=s.charAt(i);
            if(ch>='0'&&ch<='9'){
    		    if(ret>Integer.MAX_VALUE/10||(ret==Integer.MAX_VALUE/10&&
    		    		ch-'0'>Integer.MAX_VALUE%10))
    		    	return sign<0?Integer.MIN_VALUE:Integer.MAX_VALUE;
    		    ret=ret*10+(ch-'0');
    		}
            else {
            	break;
			}
        }
        return sign*ret;
    }
}
