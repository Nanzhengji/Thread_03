package threadDemo3;

public class Takener implements Runnable {
	private Computer computer=null;
	
	public Takener(Computer computer) {
		super();
		this.computer = computer;
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.computer.get();
			
		}

	}

}
