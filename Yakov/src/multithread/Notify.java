package multithread;

public class Notify extends Thread{
	
	Wait ukazatel;
	
	
	public Notify(Wait ukazatel) {
		this.ukazatel=ukazatel;
	}

	public void run(){
		try {
			sleep(5000);
			synchronized (ukazatel) {
				ukazatel.notify();
			}
			
		}catch(InterruptedException e){
			e.getMessage();
		}
	}

	
}
