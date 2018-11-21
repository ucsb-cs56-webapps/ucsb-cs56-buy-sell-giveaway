package edu.ucsb.cs56.pconrad.springboot.hello;
// Class dedicated to verifying that a post is valid
public class PostVerifier{

    /**
       Checks to see if a Posting object is valid to be added to database
       @param post The post that needs verification.
       @return true if post is valid and can be added to database, false if otherwise.
    */
    public static boolean isValid(Posting post){
	//Check title
	if(post.getTitle().isEmpty()){
	    return false;
	}
	//Check description
	else if(post.getDescription().isEmpty()){
	    return false;
	}
	//Check contact, currently only checking if empty might, might want more later on
	else if(post.getContact().isEmpty()){
	    return false;
	}
	return true;
    }
}
