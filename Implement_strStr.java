package leetcode;

import junit.framework.Assert;

public class Implement_strStr extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals("", strStr("mississippi", "issip"));

	}
	//next����������⣬����j���ַ������ʱ��Ӧ�ڱȽ�Ŀ���ַ����ĵ�next[j-1]���ַ���next[j-1]����
	//����j-1���ַ�ǰ׺�ַ����ͺ�׺�ַ����غϵ���󳤶�
    public String strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if(len2>len1) return null;
        if(len2==0) return haystack;
        int i=0,j=0;
        int[] next=get_next(needle);
        while(true){
        	while(i<len1&&j<len2&&haystack.charAt(i)==needle.charAt(j)){
        		i++;j++;
        	}
        	if(j==len2) return haystack.substring(i-j);
        	if(i==len1) break;
        	if(j==0) i++;
        	else j=next[j-1];
        }
        return null;
    }
    //j������ƥ����ַ�������������i-1��ƥ��j���ӿ�ͷ��j��,�жϵ���i���ַ���nextֵ
    //abcab 
    //    ��
    private int[] get_next(String s){
    	int len=s.length();
    	int[] next=new int[len];
    	next[0]=0;
    	for(int i=1,j=0;i<len;i++){
    		while(j>0&&s.charAt(i)!=s.charAt(j))
    			j=next[j-1]; 
    		if(s.charAt(i)==s.charAt(j))
    			j++;
    		next[i]=j;
    	}
    	return next;
    }
}
