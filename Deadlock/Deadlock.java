package com.practice.commons;

 class Class1{
	public synchronized void test1(Class2 class2) {
		System.out.println("Thread 1 Start Execution of test1(Class2 class2) method");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread 1 trying to call Class2 last method ");
		class2.last();
	}
	public synchronized void last() {
		System.out.println("Inside Class1 this is last()method");
	}
	
}
 
 class Class2 {
		public synchronized void test2(Class1 class1) {
			System.out.println("Thread 1 Start Execution of test2(Class1 class1) method");
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Thread 2 trying to call Class1 last method ");
			class1.last();
		}
		public synchronized void last() {
			System.out.println("Inside Class2 this is last()method");
		}
		
	}

public class Deadlock extends Thread {

	
		Class1 class1= new Class1();
		Class2 class2= new Class2();	
		
		public void m1() {
			this.start();
			class1.test1(class2);
		}
		public void run() {
			class2.test2(class1);
		}
		public static void main(String[] args) {
        Deadlock d= new Deadlock();
        d.m1();
	}

}
