package leetcode;

import java.util.concurrent.CyclicBarrier;



public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	private static CyclicBarrier cb;
	public static void main(String[] args){
		// TODO Auto-generated method stub
    cb = new CyclicBarrier(2, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("now the two thread is all start");
			}
		});
    for(int i=0; i < 2; i++){
    	new TestThread().start();
    }
	}
	
	static class TestThread extends Thread{
		public void run(){
			 System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
			 try {
				 cb.await();
				 System.out.println(Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
