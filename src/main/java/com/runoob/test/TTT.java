package com.runoob.test;

public class TTT implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("我已執行關閉方法");
		
	}
	
	public static void main(String[] args) throws Exception {
		try(TTT a = new TTT()){
			System.out.println(a);
		}
	}
}
