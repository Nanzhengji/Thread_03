package threadDemo3;

public class Test {

	public static void main(String[] args) {
		Computer c = new Computer();
		Producter p = new Producter(c);
		Takener t = new Takener(c);
		Thread p1 = new Thread(p);
		Thread t1 = new Thread(t);
		p1.start();
		t1.start();

	}

}
