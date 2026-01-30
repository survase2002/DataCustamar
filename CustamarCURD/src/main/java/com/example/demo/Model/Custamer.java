package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Custamer {
	@Id    //Primay key
	private Integer id;
	private String name;
	private String mob;
	private String address;
	private Float total;
	
	public Custamer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Custamer(Integer id, String name, String mob, String address, Float total) {
		super();
		this.id = id;
		this.name = name;
		this.mob = mob;
		this.address = address;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Custamer [id=" + id + ", name=" + name + ", mob=" + mob + ", address=" + address + ", total=" + total
				+ "]";
	}
	
	
	

}
