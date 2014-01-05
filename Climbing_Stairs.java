package leetcode;

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if(n==0)
        	return 0;
        int temp,pre1=0;
        int pre2=1;
        for(int i=1;i<=n;i++){
        	temp=pre2;
        	pre2=pre1+pre2;
        	pre1=temp;
        }
        return pre2;
    }
}
