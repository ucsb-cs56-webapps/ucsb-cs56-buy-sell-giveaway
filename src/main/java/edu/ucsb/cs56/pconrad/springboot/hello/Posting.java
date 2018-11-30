package edu.ucsb.cs56.pconrad.springboot.hello;

public class Posting {
	private String title;
	private String description;
//<<<<<<< HEAD
	private String contact;
	private int id;
	public Posting(String title, String description, String contact) {
		this.title = title;
		this.description = description;
		this.contact = contact;
		this.id=0;
//======
	}
	private String email;
	private String number;
	private int approved;

	public Posting(String title, String description, String email, String number) {
		this.title = title;
		this.description = description;
		this.email = email;
		this.number = number;
		this.approved = 0;
//>>>>>>> 422f3bc8d9bf18ecf8e799571a26e58c7bf27d79
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getEmail() {
		return email;
	}

	public String getNumber() {
		return number;
	}
	public int getID() {
                return id;
        }

	public void setApproved() {
		this.approved = approved;
	}
}
