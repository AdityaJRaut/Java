package threads;

public class ThreadDemo implements Runnable {

	public static void main(String[] args) {

		ThreadA A = new ThreadA();
		ThreadB B = new ThreadB();
		ThreadDemo TD = new ThreadDemo();
		TD.run();
		A.run();
		B.run();

	}

	@Override
	public void run() {
		for (char i = 'a'; i <= 'z'; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
