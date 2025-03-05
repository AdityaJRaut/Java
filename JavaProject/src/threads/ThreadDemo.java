package threads;

public class ThreadDemo extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {

			ThreadDemo td = new ThreadDemo();
			td.start();
		}
	}
}
