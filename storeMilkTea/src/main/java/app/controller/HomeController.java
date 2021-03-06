package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value="/")
	public ModelAndView index(){
		logger.info("home page");
		ModelAndView model = new ModelAndView("home");
		return model;
	}

}
