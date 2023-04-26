/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


public class Location {
	
	private String city;
	private String street;
	private int zipCode;
	
	public Location(String city, String street, int zipCode) {
		super();
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Location [city=" + city + ", street=" + street + ", zipCode=" + zipCode + "]";
	}
	
}
