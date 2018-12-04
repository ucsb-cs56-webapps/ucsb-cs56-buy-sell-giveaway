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

@Controller
public class HelloController {

	@Autowired
	private PostRepository repository;

    ArrayList<Posting> postingsNeedApproval = new ArrayList<Posting>();
    ArrayList<Posting> postingsApproved = new ArrayList<Posting>();

	ArrayList<Post> bufNeedApproval = new ArrayList<Post>();
	ArrayList<Post> bufApproved = new ArrayList<Post>();

    @RequestMapping("/")
    public ModelAndView index() {

	postingsApproved.clear();
	bufApproved = repository.findByApproved("1");

	for(Post p : bufApproved){
		postingsApproved.add(new Posting(p.getTitle(),p.getDescription(),p.getEmail(),p.getPhone(),p.getId()));
	}
	System.out.println(postingsApproved);

	Map<String, Object> params = new HashMap<>();
	params.put("postings", postingsApproved);

	return new ModelAndView("index", params);
    }

    //Info on @RequestParam: http://zetcode.com/springboot/requestparam/
    @RequestMapping("/new_post")
    public String new_post_form(Model model, @RequestParam(value="title",required=true,defaultValue="") String title,
				@RequestParam(value="desc",required=true,defaultValue="") String desc,
				@RequestParam(value="email",required=true,defaultValue="") String email,
				@RequestParam(value="number",required=true,defaultValue="") String number){
	//Create a posting object for new post
	//Generate Random Number for ID
	//Random rand = new Random();
	//Some Range
	//int max = 1000000;
	//int min = 1;
	//https://stackoverflow.com/questions/363681/how-to-generate-random-integers-within-a-specific-range-in-java
	//int randomNum = rand.nextInt((max-min)+1)+min;
	Posting newPost = new Posting(title,desc,email,number,"0");

	if(PostVerifier.isValid(newPost)){
	    //postingsNeedApproval.add(newPost);
		repository.save(new Post(title,desc,email,number,"0"));
	    //Found how to redirect on this article: https://o7planning.org/en/11547/spring-boot-and-freemarker-tutorial
	    return "redirect:/";
	}

	//Bad post
	return "new_post";
    }

    //To-do Implement github logins so we can have admins to the site and review/approve post.
    @RequestMapping("/admin_login")
    public String admin_login(){
	//Update when implmented
	return "/";
    }

    //http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
    //Deals with approval button on admin
    //This will be the page were we do all the verification.
    @RequestMapping("/admin")
    public ModelAndView admin(){

		postingsNeedApproval.clear();
		bufNeedApproval = repository.findByApproved("0");

		for(Post p : bufNeedApproval){
			postingsNeedApproval.add(new Posting(p.getTitle(),p.getDescription(),p.getEmail(),p.getPhone(),p.getId()));
		}
		System.out.println(postingsNeedApproval);

		Map<String, Object> params = new HashMap<>();
		params.put("postings", postingsNeedApproval);

		return new ModelAndView("admin", params);
    }

    // https://hellokoding.com/spring-boot-hello-world-example-with-freemarker/
    //https://stackoverflow.com/questions/49154565/how-to-call-a-method-with-a-button-in-freemarker-dropwizard
    //https://spring.io/guides/tutorials/rest/

    //In the FTL file the action has to be action = /approve/${posting.id} to work. Also this value is a string so needs to be parse into int.
    @GetMapping("/approve/{idString}")
    public String approve(Model model, @PathVariable String idString) {
		//idString has a comma we need to deal with before parsing
		idString=idString.replace(",","");
		//int id = Integer.parseInt(idString);
		Post temp = repository.findOneById(idString);

		repository.save(new Post(temp.getTitle(),temp.getDescription(),temp.getEmail(),temp.getPhone(),"1"));
		repository.delete(temp);

		updateNonApprovedList();
		updateApprovedList();
		/*
		Posting temp;
		for(int i = 0; i< postingsNeedApproval.size();i++){
		    temp = postingsNeedApproval.get(i);
		    if(id == temp.getId()){
			postingsApproved.add(temp);
			postingsNeedApproval.remove(i);
			break;
		    }

		}
	*/

	return "redirect:/admin";
    }

     @GetMapping("/remove/{idString}")
    public String remove(Model model, @PathVariable String idString) {
	//idString has a comma we need to deal with before parsing
	idString=idString.replace(",","");
	//int id = Integer.parseInt(idString);
	//Posting temp;
	Post temp = repository.findOneById(idString);
	repository.delete(temp);

	updateNonApprovedList();
	updateApprovedList();

	/*
	for(int i = 0; i< postingsNeedApproval.size();i++){
	    temp = postingsNeedApproval.get(i);
	    if(id == temp.getId()){
		postingsNeedApproval.remove(i);
		break;
	    }
	}
	*/

	return "redirect:/admin";
    }

	public void updateApprovedList(){
		postingsApproved.clear();
		bufApproved = repository.findByApproved("1");

		for(Post p : bufApproved){
			postingsApproved.add(new Posting(p.getTitle(),p.getDescription(),p.getEmail(),p.getPhone(),p.getId()));
		}
	}

	public void updateNonApprovedList(){
		postingsNeedApproval.clear();
		bufNeedApproval = repository.findByApproved("0");

		for(Post p : bufNeedApproval){
			postingsNeedApproval.add(new Posting(p.getTitle(),p.getDescription(),p.getEmail(),p.getPhone(),p.getId()));
		}
	}

}
