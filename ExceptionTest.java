package leetcode;

public class ExceptionTest {
	public static void main(String[] args){ 
		int a=0;
	    try{ 
	        a=doStuff(-1); 
	        doStuff(100); 
	    }catch(Exception e){ 
	        System.out.println("��������Զ�����ᵽ���"); 
	    } 
	    System.out.println(a);
	} 
	//�÷����׳��ܼ��쳣 
	public static int doStuff(int _p)throws Exception{ 
	    try{ 
	        if(_p < 0){ 
	            throw new ArrayIndexOutOfBoundsException("���ݸ�ʽ����"); 
	        }else{ 
	            return _p; 
	        } 
	    }catch(Exception e){ 
	        //�쳣���� 
	        throw e; 
	    }finally{ 
//	        return -1; 
	    } 
	} 
}
