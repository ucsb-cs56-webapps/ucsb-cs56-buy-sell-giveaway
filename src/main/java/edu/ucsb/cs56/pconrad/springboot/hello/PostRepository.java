package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface PostRepository extends MongoRepository<Post, String> {
    //public Post findByCode(String code);
	public Post findOneById(String id);
<<<<<<< HEAD
	public ArrayList<Post> findByApproved(String approved);
    public ArrayList<Post> findAll();
    public void delete(Post b);
=======
	//public Post findOneByApproved(String approved);
    public ArrayList<Post> findAll();
    //public void delete(Post b);
>>>>>>> 18c4879d1b239d0b1c8132b56c0718da62bca956
    //public void deleteAll();
}
