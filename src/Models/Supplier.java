package Models;

public class Supplier {
	private long id;	
	private long cvr;
	private String name;
	private Address address;
	private int phoneno;
	private String email;
		 
	public Supplier(long id,long cvr, String name, Address address, int phoneno, String email) {
		this.id = id;
		this.cvr = cvr;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCvr() {
		return cvr;
	}
	public void setCvr(long cvr) {
		this.cvr = cvr;
	}
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
