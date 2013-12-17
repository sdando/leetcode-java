package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Add_Binary {

	@Test
	public void testSolution(){
		JunitTest.Print(Solution.addBinary("1", "0"));
	}
	
	static class Solution{
		public static String addBinary(String a, String b) {
			if (a =="") {
				return b;
			} else if (b =="") {
				return a;
			}
			int aLength = a.length();
			int bLength = b.length();
			StringBuilder aBf=new StringBuilder(a);
			StringBuilder bBf=new StringBuilder(b);
			aBf.reverse();
			bBf.reverse();
			int i = 0;
			int cLength=Math.max(aLength, bLength);
			while(i<cLength-aLength){
				aBf.append("0");
				i++;
			}
			i=0;
			while(i<cLength-bLength){
				bBf.append("0");
				i++;
			}
			StringBuilder cBf=new StringBuilder();
			int result,add1,add2,adding=0;
			for(i=0;i<cLength;i++){
				add1=Integer.parseInt(aBf.substring(i,i+1));
				add2=Integer.parseInt(bBf.substring(i,i+1));
				result=add1^add2^adding;
				cBf.append(result);
				if(adding==1) {
					if(add1==0&&add2==0)
						adding=0;
					else
						adding=1;
				} else {
					if (add1==1&&add2==1)
						adding=1;
					else
						adding=0;
				}
			}
            if(adding==1)
            	cBf.append(adding);
            return cBf.reverse().toString();
		}
	}
}
