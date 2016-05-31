package multithread;

public class ARunable implements Runnable {
	
	private String name ;
	
	@Override
	public void run() {
		System.out.println("run class A");
		
	}

}
