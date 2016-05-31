package multithread.thread;

public class TestWait {
	
	TestWait(){
		System.out.println("Start wait and notify:");
		synchronized (this) {
			try{
				wait(10000);
				System.out.println("FINISH wait and notify:");
			}catch (InterruptedException e) {
			System.out.println(e.getMessage());
			}
		}
	}


}
