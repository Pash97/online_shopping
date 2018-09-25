package net.pash.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping (value={"/","/index","/home"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", "Hello World..!");
		return mv;
	}
}