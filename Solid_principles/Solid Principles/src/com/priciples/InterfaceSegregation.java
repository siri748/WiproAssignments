package com.priciples;
interface Work{
	void work();
}
interface Eat{
	void eat();
}
class Humans implements Work,Eat{
	public void work() {
		System.out.println("Humans are eating");
	}
	public void eat() {
		System.out.println("Humans are watching");
	}
}
class Animals implements Eat{
	public void eat() {
		System.out.println("Animals are Playing");
	}
	
}

public class InterfaceSegregation {
	public static void main(String[] args) {
		Humans h=new Humans();
		h.work();
		h.eat();
		
		Animals a=new Animals();
		a.eat();
		
	}

	

}
