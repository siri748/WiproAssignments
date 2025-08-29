package com.priciples;
class Student{
	String name;
	
	Student(String name){
		this.name=name;
	}
}

class Print{
	void print(Student s) {
		System.out.println("Name is : "+s.name);
	}
}

public class Single {
public static void main(String[] args) {
		
		Student s=new Student("Priyanka");
		Print p=new Print();
		p.print(s);
		
	}

	

}