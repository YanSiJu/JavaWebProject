package com.qzdatasoft.javaweb;

public class StudentInfo {

	public StudentInfo() {

	}

	public StudentInfo(String name, int age, String sno, String sex, String tel) {
		
		
		this.name = name;
		this.age = age;
		this.sno = sno;
		this.sex = sex;
		this.Tel = tel;
	}

	private String name;
	private int age;
	private String sno;
	private String sex;
	private String Tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

}
