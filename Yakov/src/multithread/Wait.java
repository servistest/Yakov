package multithread;

public class Wait {
	
	 void begin() {
		
		Notify n=new Notify(this);
		n.start();
		System.out.println("Start test:");
		synchronized (this) {
			try{
				wait();
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}	
		System.out.println("Stop test:");
		
	}
	
	
	
	
}
