package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface PostRepository extends MongoRepository<Post, String> {
    public Post findOneById(String id);
    public ArrayList<Post> findAll();
    public ArrayList<Post> findByApproved(String approved);
    public void delete(Post b);
}
