package com.example.student.controller;

public class Student {
	private int sId;
	private String sName;
	private float sMarks;
	private String city;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public float getsMarks() {
		return sMarks;
	}

	public void setsMarks(float sMarks) {
		this.sMarks = sMarks;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
