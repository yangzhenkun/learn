package com.yasin.common.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yasin.check.Check;

public class Person {

	private Long id;
	
	@Check
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	
	/**
	 * 按照各字段生成hash值，这样该类如果所有的字段都相等，那么该对象的hash值是一样的
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
