package com.fpc.Test;

public class synchronizedTest {
	// synchronized修饰非静态方法
	public synchronized void function() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.println("function running......");
		}
	}

	// synchronized修饰静态方法
	public synchronized static void staticFunction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.println("staticFunction running.......");
		}
	}

	public static void main(String[] args) {
		final synchronizedTest demo = new synchronizedTest();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				try {
					synchronizedTest.staticFunction();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				try {
					demo.function();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}