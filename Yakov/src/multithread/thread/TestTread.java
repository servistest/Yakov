package multithread.thread;

public class TestTread {
	

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start:");
		
	//	AThread a=new AThread("AThread");
//		a.start();
		BThread b=new BThread("BThread");
		b.start();
		b.sleep(1000);
		System.out.println("Comand stop");
		b.stopMe();
		System.out.println("Test finish");
		TestWait testWait=new TestWait();
		
	
 }
}
