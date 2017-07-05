package learnJava;

import java.util.List;

public class User {
	
	public String name;
	public String eyeColor;
	public double height;
	public int height1;
	public Boolean a;
	public boolean b;
	public String color;
	public String relegion;
	public String race;
	public Car car;
	public Home home;
	public List<Job> jobs;
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", eyeColor=" + eyeColor + ", height=" + height + ", height1=" + height1 + ", a="
				+ a + ", b=" + b + ", color=" + color + ", relegion=" + relegion + ", race=" + race + ", car=" + car
				+ ", home=" + home + ", jobs=" + jobs + "]";
	}
	

	
	

}
