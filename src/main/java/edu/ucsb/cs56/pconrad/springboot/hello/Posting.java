package edu.ucsb.cs56.pconrad.springboot.hello;

public class Posting {
    private String title;
    private String description;
    private String contact;
    private int id;
    

    public Posting(String title, String description, String contact,int id) {
	this.title = title;
	this.description = description;
	this.contact = contact;
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public String getDescription() {
	return description;
    }

    public String getContact() {
	return contact;
    }

    public int getId(){
	return id;
    }

}
