package pojo;

import java.util.List;

public class Student {
	private int doc;//加个伪id，防止resultMap自动根据cno去重
	
	private Integer cno;
	private String name;
	private Integer classno;
	private String sex;
	
	private Phone phone1;
	private Class class1;
	
	private List<Phone> phoneList;//获取改人员手机号列表

	public List<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	public int getDoc() {
		return doc;
	}
	public void setDoc(int doc) {
		this.doc = doc;
	}
	
	public Phone getPhone1() {
		return phone1;
	}
	public void setPhone1(Phone phone1) {
		this.phone1 = phone1;
	}
	public Class getClass1() {
		return class1;
	}
	public void setClass1(Class class1) {
		this.class1 = class1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Integer getClassno() {
		return classno;
	}
	public void setClassno(Integer classno) {
		this.classno = classno;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
