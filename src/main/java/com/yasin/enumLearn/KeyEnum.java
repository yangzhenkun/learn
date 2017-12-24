package com.yasin.enumLearn;

public enum KeyEnum {
	
	id("id","id主键"),type("type","线索类型");
	
	private String name;
	private String remark;
	
	private KeyEnum(String name,String remark){
		this.name=name;
		this.remark=remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
