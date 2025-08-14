package testdata.classes;

import utils.Reader;

public class Client {

	private String firstname;
	private String lastname;
    private String postalcode;
	
	public Client(String filename) {
		this.firstname=Reader.json(filename).get("firstname").toString();
		this.lastname=Reader.json(filename).get("lastname").toString();
		this.postalcode=Reader.json(filename).get("postalcode").toString();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
}