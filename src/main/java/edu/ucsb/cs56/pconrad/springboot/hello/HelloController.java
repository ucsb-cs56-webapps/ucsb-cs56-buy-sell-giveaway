package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
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
