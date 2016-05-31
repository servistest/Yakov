package multithread.thread;

 public class BThread extends Thread{
	 private volatile Boolean stopMe=false;
	
	public BThread(String name) {
		super(name);
	}
	public void stopMe() {
		stopMe=true;
	}
	
	public void run(){
		try {
			int i=0;
			while(!stopMe){
				sleep(700);
				System.out.println("Write class B" +i);
				i++;
			}
			
		}catch(InterruptedException e){
			System.out.println(Thread.currentThread().getName()+e.getMessage());
		}
		
	}

}
