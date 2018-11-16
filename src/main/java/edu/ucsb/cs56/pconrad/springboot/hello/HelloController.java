package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.ucsb.cs56.pconrad.springboot.hello.Posting;
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
	@RequestMapping("/")
	public ModelAndView index() {
		ArrayList<Posting> postings = new ArrayList<Posting>();
		postings.add(new Posting("What a title!", "Great description!", "Number: 555-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 2!", "Great description 2!", "Number: 444-555-5555\nEmail: fake@email.com"));
		postings.add(new Posting("What a title 3!", "Great description 3!", "Number: 333-555-5555\nEmail: fake@email.com"));

		System.out.println(postings);

		Map<String, Object> params = new HashMap<>();
		params.put("postings", postings);

		return new ModelAndView("index", params);
	}


	@RequestMapping("/search")
	public String search() {
		return "search";
	}

	@RequestMapping("/sell")
	public String sell() {
		return "sell";
	}

	@RequestMapping("/free")
	public String free(){
		return"free";
	}

	@RequestMapping("/textbook")
	public String textbook(){
		return"textbook";
	}

	@RequestMapping("/recreation")
	public String recreation(){
		return "recreation";
	}

	@RequestMapping("/transportation")
	public String transportation(){
		return("transportation");
	}

	@RequestMapping("/supplies")
	public String supplies(){
		return("supplies");
	}

	@RequestMapping("/all")
	public String all(){
		return("all");
	}

	@RequestMapping("/other")
	public String other() {
		return("other");
	}

}
