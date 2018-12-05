package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface PostRepository extends MongoRepository<Post, String> {
    //public Post findByCode(String code);
	public Post findOneById(String id);
<<<<<<< HEAD
	//public Post findOneByApproved(String approved);
    public ArrayList<Post> findAll();
    //public void delete(Post b);
    //public void deleteAll();
}

=======
	public ArrayList<Post> findByApproved(String approved);
    public ArrayList<Post> findAll();
    public void delete(Post b);
    //public void deleteAll();
}
>>>>>>> fd8513b7879d0a7e0724ef46d0c138fbeb150148
