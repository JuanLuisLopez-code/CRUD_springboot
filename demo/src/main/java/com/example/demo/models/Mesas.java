package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	public Mesas() {

	}

	public Mesas(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + "]";
	}

}
