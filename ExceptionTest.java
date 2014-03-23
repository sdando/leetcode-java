package leetcode;

public class ExceptionTest {
	public static void main(String[] args){ 
		int a=0;
	    try{ 
	        a=doStuff(-1); 
	        doStuff(100); 
	    }catch(Exception e){ 
	        System.out.println("这里是永远都不会到达的"); 
	    } 
	    System.out.println(a);
	} 
	//该方法抛出受检异常 
	public static int doStuff(int _p)throws Exception{ 
	    try{ 
	        if(_p < 0){ 
	            throw new ArrayIndexOutOfBoundsException("数据格式错误"); 
	        }else{ 
	            return _p; 
	        } 
	    }catch(Exception e){ 
	        //异常处理 
	        throw e; 
	    }finally{ 
//	        return -1; 
	    } 
	} 
}
