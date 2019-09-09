package com.test;

public class Test {
    static final Object object = new Object();

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(
				new Runnable() {
			    @Override
			      public void run() {
					synchronized(object){
						 for(int i=0;i<100;i++){
							 System.out.println(Thread.currentThread().getName()+"，数值："+(i*2));
							 object.notify();
							 try {
								object.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    
						 }
					}
				   }
				});
		
		Thread thread2 = new Thread(
				new Runnable() {
			    @Override
			      public void run() {
					synchronized(object){
						 for(int i=0;i<100;i++){
							 System.out.println(Thread.currentThread().getName()+"，数值："+(i*2+1));
							 object.notify();
							 try {
								object.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    
						 }
					}
				   }
				});
		thread1.start();
		thread2.start();

	   }

}
