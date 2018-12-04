package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.ucsb.cs56.pconrad.springboot.hello.Posting;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

//yinon was here
@Controller
public class HelloController {
	/*
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	*/

	@Autowired
	private PostRepository repository;

    ArrayList<Posting> postings = new ArrayList<Posting>();
	ArrayList<Post> tmpPostList = new ArrayList<Post>();

    @RequestMapping("/")
    public ModelAndView index() {
	/*ArrayList<Posting> postings = new ArrayList<Posting>();
		postings.add(new Posting("What a title!", "Great description!", "Number: 555-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 2!", "Great description 2!", "Number: 444-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 3!", "Great description 3!", "Number: 333-555-5555\nEmail: fake@email.com"));
	*/
		postings.clear();
		tmpPostList = repository.findAll();

		for(Post p : tmpPostList){
		    postings.add(new Posting(p.getTitle(),p.getDescription(),p.getEmail(),p.getPhone(),p.getId()));
		}

		System.out.println(postings);

		Map<String, Object> params = new HashMap<>();
		params.put("postings", postings);

		return new ModelAndView("index", params);
	}

    //Info on @RequestParam: http://zetcode.com/springboot/requestparam/
    @RequestMapping("/new_post")
    public String new_post_form(Model model, @RequestParam(value="title",required=true,defaultValue="") String title,
				@RequestParam(value="desc",required=true,defaultValue="") String desc,
				@RequestParam(value="email",required=true,defaultValue="") String email,
				@RequestParam(value="number",required=true,defaultValue="") String number){
	Posting newPost = new Posting(title,desc,email,number,id);
	    if(PostVerifier.isValid(newPost)){
		//postings.add(newPost);
		repository.save(new Post(title,desc,email,number,"0"));
		//Found how to redirect on this article: https://o7planning.org/en/11547/spring-boot-and-freemarker-tutorial
		return "redirect:/";
	    }
	    //Don't know if I need the following line?
	    //model.addAttribute("new_post", new Posting(title,desc,contact));

	    //Bad post
	    return "new_post";
    }
}
