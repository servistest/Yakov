package multithread.thread;

public class AThread extends Thread{
	
	public AThread(String name) {
		super(name);
	}
	
	public void run(){
		try {
			for (int i=0;i<10;i++){
				sleep(1000);
				System.out.println("Write class A" +i);
			}
			
		}catch(InterruptedException e){
			System.out.println(Thread.currentThread().getName()+e.getMessage());
		}
		
	}

}
