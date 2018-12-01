package threadDemo3;

public class Producter implements Runnable {
	private Computer computer = null;
	
	public Producter(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void run() {
		boolean flag=false;
		for(int i=0;i<50;i++) {
			if(flag) {
				this.computer.set("联想电脑",200);
				flag=false;
			}else {
				this.computer.set("戴尔电脑",300);
				flag=true;
			}
		}
	}

}
