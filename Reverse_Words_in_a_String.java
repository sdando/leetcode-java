package leetcode;

public class Reverse_Words_in_a_String extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        String ret=reverseWords("the sky   is blue ");
        return;
	}
	
    public String reverseWords(String s) {
        String[] tokens=s.trim().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=tokens.length-1;i>=0;i--){
        	if(!"".equals(tokens[i])){
        		sb.append(tokens[i]);
        		if(i!=0)
        			sb.append(" ");
        	}
        }
        return sb.toString();
    }

}
