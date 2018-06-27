package com.fpc.Test;

public class synchronizedTest {
	// synchronized���ηǾ�̬����
	public synchronized void function() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.println("function running......");
		}
	}

	// synchronized���ξ�̬����
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
				// TODO �Զ����ɵķ������
				try {
					synchronizedTest.staticFunction();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				try {
					demo.function();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}