package leetcode;

import junit.framework.Assert;

public class ZigZag_Conversion extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
	}
	//j is the position in s
    public String convert(String s, int nRows) {
        if(nRows==1) return s;
        StringBuilder sb=new StringBuilder();
        int length=s.length();
        for(int i=0;i<nRows;i++)
        	for(int j=i;j<length;j+=(2*nRows-2)){
        		sb.append(s.charAt(j));
        		if(i>0&&i<nRows-1){
        			if(j+2*(nRows-i-1)<length)
        			    sb.append(s.charAt(j+2*(nRows-i-1)));
        		}
        	}
        return sb.toString();
    }
}
