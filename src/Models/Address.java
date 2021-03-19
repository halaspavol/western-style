package Models;

public class Address {
	private Long addressId;
	private String street;
	private String houseNo;
	private String zipcode;
	private String city;
		
	public Address(Long addressId, String street, String houseNo, String zipcode, String city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.houseNo = houseNo;
		this.zipcode = zipcode;
		this.city = city;
	}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
