package threadDemo3;

public class Computer {
	private String name = "联想";
	private Integer money = 200;
	

	private boolean flag = false;//true生产,false卖出
	
	public synchronized void set(String name,Integer money) {
			if(!flag) {
				try {
					super.wait();//flag为false,不能生产
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.setName(name);//flag为true,可以生产
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setMoney(money);
			flag=false;
			super.notify();
	}
	
	public synchronized void get() {
			if(flag) {
				try {
					super.wait();//flag为true,不能卖出
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//
			}
			//卖出一台后,唤醒生产线程继续生产
			System.out.println("卖出一台:"+this.getName()+"  "+this.getMoney());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag=true;
			super.notify();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
}
