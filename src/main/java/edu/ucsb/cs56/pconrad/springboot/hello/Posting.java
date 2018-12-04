package edu.ucsb.cs56.pconrad.springboot.hello;

public class Posting {

    private String title;
    private String description;
    private String email;
    private String number;
    private int approved;
    private String id;

	public Posting(String title, String description, String email, String number, String id) {
	this.title = title;
	this.description = description;
	this.email = email;
	this.number = number;
	this.approved = 0;
	this.id = id;
    }

    public Posting(String title, String description, String email, String number) {
	this.title = title;
	this.description = description;
	this.email = email;
	this.number = number;
	this.approved = 0;
    }    

    public String getTitle() {
	return title;
    }

    public String getDescription() {
	return description;
    }


    public String getId(){
	return id;
    }
    public void setId(String id){
	this.id = id;
    }


    public String getEmail() {
	return email;
    }

    public String getNumber() {
	return number;
    }

    public void setApproved() {
	this.approved = approved;
    }

}
