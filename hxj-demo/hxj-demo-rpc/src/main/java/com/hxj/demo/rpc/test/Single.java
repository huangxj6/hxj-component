package com.hxj.demo.rpc.test;
public class Single{

	private static volatile Single obj;
	
	public static Single getObj(){
	
		if(obj == null){
			synchronized(Single.class){
				if(obj == null){
					obj = new Single();
				}
			}
		}
		
		return obj;
	}
}