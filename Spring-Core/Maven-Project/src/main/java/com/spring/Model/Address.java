package com.spring.Model;

public class Address {

	private String city, state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address(String city, String state) {
		this.city = city;
		this.state = state;
	}

	public void called()
	{
		System.out.println("Hey, you have called the OBJ of address.");
	}
	public Address() {

	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}

}
