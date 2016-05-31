package multithread;

public class BRunable implements Runnable{
	private String name ;
	
	
	@Override
	public void run() {
		System.out.println("run class B");
		
	}
	
}
