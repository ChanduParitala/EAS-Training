package com.spring.Model;

public class Student {
	private int eId;
	private String eName;
	private Address addressWire;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Address getAddressWire() {
		return addressWire;
	}

	public void setAddressWire(Address address) {
		this.addressWire = address;
	}
	
	public void callObj() {
		addressWire.called();
	}

	public Student(int eId, String eName, Address addressWire) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.addressWire = addressWire;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [eId=" + eId + ", eName=" + eName + ", city=" + addressWire.getCity() + ", state="
				+ addressWire.getState() + "]";
	}

}
