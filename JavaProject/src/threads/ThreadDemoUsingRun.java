package threads;

public class ThreadDemoUsingRun extends Thread {

	public static void main(String[] args) {
		ThreadDemoUsingRun tdr = new ThreadDemoUsingRun();
		ThreadA A = new ThreadA();
		ThreadB B = new ThreadB();
		B.run();
		A.start();
		System.out.println(tdr.getPriority());
		tdr.setPriority(MAX_PRIORITY);
		System.out.println(tdr.getPriority());

	}

	public void run() {
		System.out.println("start");
	}

}
