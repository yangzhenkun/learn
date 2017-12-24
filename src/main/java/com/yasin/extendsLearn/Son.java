package com.yasin.extendsLearn;

public class Son extends Parent {
	
	private String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "s:"+s+"p:"+getP();
	}
	

}
