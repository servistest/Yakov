package multithread;

public class test {

	public static void main(String[] args) {
		
		ARunable a =new ARunable();
		Thread  threadA=new Thread(a, "ThreadA");
		threadA.start();
		
		ARunable b =new ARunable();
		Thread  threadB=new Thread(b, "ThreadB");
		threadB.start();
		System.out.println("Test finish.");		
	}

}
