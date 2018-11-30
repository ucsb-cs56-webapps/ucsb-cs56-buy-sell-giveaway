package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.ucsb.cs56.pconrad.springboot.hello.Posting;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
@Controller
public class HelloController {
	/*
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	*/

   
    ArrayList<Posting> postingsNeedApproval = new ArrayList<Posting>();
    ArrayList<Posting> postingsApproved = new ArrayList<Posting>();
    
    @RequestMapping("/")
    public ModelAndView index() {
	/*ArrayList<Posting> postings = new ArrayList<Posting>();
		postings.add(new Posting("What a title!", "Great description!", "Number: 555-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 2!", "Great description 2!", "Number: 444-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 3!", "Great description 3!", "Number: 333-555-5555\nEmail: fake@email.com"));
	*/
		System.out.println(postingsApproved);

		Map<String, Object> params = new HashMap<>();
		params.put("postings", postingsApproved);
		
		return new ModelAndView("index", params);
	}

    //Info on @RequestParam: http://zetcode.com/springboot/requestparam/
    @RequestMapping("/new_post")
    public String new_post_form(Model model, @RequestParam(value="title",required=true,defaultValue="") String title,
				@RequestParam(value="desc",required=true,defaultValue="") String desc,
				@RequestParam(value="contact",required=true,defaultValue="") String contact){
	Posting newPost = new Posting(title,desc,contact);
	if(PostVerifier.isValid(newPost)){
	    postingsNeedApproval.add(newPost);
	    model.addAttribute("new_post", new Posting(title,desc,contact));

	    ;

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

    //https://stackoverflow.com/questions/49154565/how-to-call-a-method-with-a-button-in-freemarker-dropwizard
    //http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
    //Deals with approval button on admin 
    //This will be the page were we do all the verification.
    @RequestMapping("/admin")
    public ModelAndView admin(Model model,@RequestParam(value="index",required=true,defaultValue="")String index){
	System.out.println(postingsNeedApproval);

	Map<String, Object> params = new HashMap<>();
	params.put("postings", postingsNeedApproval);

	if(!index.isEmpty()){
	    /*Not working
	    
	    //Get IDs
	    String[] strArray = index.split(",");
	    int[] intArray = new int[strArray.length];
	    for(int i = 0; i < strArray.length; i++) {
		intArray[i] = Integer.parseInt(strArray[i]);
	    }	    
	    //Go through IDs and add to approve and remove from needs approval
	    for(int i = 0; i<intArray.length;i++){
		postingsApproved.add(postingsNeedApproval.get(intArray[i]));
		postingsNeedApproval.remove(intArray[i]);
	    }
	    */
	    int tempInt = Integer.parseInt(index);
	    postingsApproved.add(postingsNeedApproval.get(tempInt));
	    postingsNeedApproval.remove(tempInt);
	}
		
	return new ModelAndView("admin", params);
    }

  
}
