package testdata.classes;

import utils.Reader;

public class Item {

	private String name;
	private String description;
	private String price;
	
	public Item(String filename) {
		this.name=Reader.json(filename).get("name").toString();
		this.description=Reader.json(filename).get("description").toString();
		this.price=Reader.json(filename).get("price").toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
