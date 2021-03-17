package Models;

public class Supplier {
	private Long cvr;
	private String name;
	private String address;
	private int phoneno;
	private String email;
	
	public Long getCvr() {
		return cvr;
	}
	public void setCvr(Long cvr) {
		this.cvr = cvr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
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
