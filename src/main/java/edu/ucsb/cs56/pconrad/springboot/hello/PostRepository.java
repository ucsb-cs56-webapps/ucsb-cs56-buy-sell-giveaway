package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface PostRepository extends MongoRepository<Post, String> {
    //public Post findByCode(String code);
	public Post findOneById(String id);
	public ArrayList<Post> findByApproved(String approved);
    public ArrayList<Post> findAll();
    public void delete(Post b);
    //public void deleteAll();
}
